package com.arturo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arturo.model.Articulo;
import com.arturo.model.ArticuloCesta;
import com.arturo.model.Cesta;
import com.arturo.service.IArticulosCestasService;
import com.arturo.service.IArticulosService;
import com.arturo.service.ICestasService;

@Controller
public class CestaController {
	
	@Autowired
	private ICestasService serviceCestas;
	
	@Autowired
	private IArticulosCestasService serviceArticulosCestas;
	
	@Autowired
	private IArticulosService serviceArticulos;		
	
	private int numArticulos = 0;
	private String tipo = "c";
	
	@GetMapping("cesta/index")
	public String mostrarArticulos(	
									Model model,			
									RedirectAttributes attributes) {
		double importeCesta = 0;
		numArticulos = 0;
		
		if(UsuarioController.userId == 0){
			attributes.addFlashAttribute("msg","para acceder a tu cesta tienes que entrar con tu usuario");
			return "redirect:/";			
		}
		
		List<Cesta> lCesta = serviceCestas.buscarCesta(UsuarioController.userId, tipo);
		// solo puede haber una cesta por usuario
		Cesta cesta= new Cesta();
		if(lCesta.size() > 0){
			cesta = lCesta.get(0);
		} else {
			cesta = null; 
		}		
				
		if(cesta==null) {
			attributes.addFlashAttribute("msg","no tienes ningún articulo en la cesta!");
			return "redirect:/";
		}
		
		ArrayList<Articulo> aListArtic = new ArrayList<Articulo>();				
		List<ArticuloCesta> listAc = serviceArticulosCestas.buscarArticulos(cesta.getId());	
		
		for (ArticuloCesta artC : listAc) {
			Articulo art = new Articulo();
			int idArt = artC.getIdArticulo();
			numArticulos = numArticulos + 1;			
			importeCesta = importeCesta + artC.getImporte(); 			

			art = serviceArticulos.buscarPorId(idArt);
			System.out.println("articulo que queda en la cesta..." + art.toString());
			aListArtic.add(art);			

		}
		cesta.setImporte(importeCesta);
		// actualizo la cesta con el importe total de todos los articulos 
		serviceCestas.guardarCesta(cesta);
		
		model.addAttribute("cestaActiva", cesta);
		model.addAttribute("articulos", aListArtic);
		model.addAttribute("numArticulos", numArticulos);
		model.addAttribute("userId", UsuarioController.userId);
		model.addAttribute("userNombre", UsuarioController.userNombre);
		
		return "cesta";		
	}

	@GetMapping("/articulo/cesta")
	public String altaCesta(@RequestParam("idArticulo") Integer id,
							@RequestParam("idUser") Integer idusuario,
							RedirectAttributes attributes, Model model) {
		
		double importeCesta = 0;		
		
		if(idusuario == 0){
			attributes.addFlashAttribute("msg","para acceder a tu cesta tienes que entrar con tu usuario");
			return "redirect:/";			
		}
		
		ArticuloCesta ac  = new ArticuloCesta();
		ArticuloCesta ac2 = new ArticuloCesta();
		Articulo articulo = serviceArticulos.buscarPorId(id);	
		
		List<Cesta> lCesta = serviceCestas.buscarCesta(UsuarioController.userId, tipo);
		
		// solo puede haber una cesta por usuario				
		Cesta cesta= new Cesta();
		if(lCesta.size() > 0){
			cesta = lCesta.get(0);
		} else {
			cesta = null; 
		}				
		
		ArrayList<Articulo> aListArt = new ArrayList<Articulo>();		

		if (cesta == null) {
			System.out.println("Objeto cesta es null...");

			if (articulo == null) {
				System.out.println("Objeto articulo es null...");
				attributes.addFlashAttribute("msg", "No existe el articulo para asociarle a la cesta");
				

			} else {
				Cesta altaCesta = new Cesta();
				altaCesta.setImporte(articulo.getPrecio());
				altaCesta.setIdUsuario(idusuario);

				// Damos de alta la fecha de la cesta con la del día
				Date myDate = new Date();
				altaCesta.setFecha(myDate);	
				altaCesta.setTipo(tipo);

				serviceCestas.guardarCesta(altaCesta);

				ac.setIdArticulo(id);
				ac.setIdCesta(altaCesta.getId());
				ac.setCantidad(1);
				ac.setImporte(articulo.getPrecio());

				serviceArticulosCestas.altaArticuloCesta(ac);

				List<ArticuloCesta> listAc = serviceArticulosCestas.buscarArticulos(altaCesta.getId());				
				
				for (ArticuloCesta artC : listAc) {
					Articulo art = new Articulo();
					int idArticulo = artC.getIdArticulo();
					numArticulos = numArticulos + 1;					
					importeCesta = importeCesta + artC.getImporte(); 
					art = serviceArticulos.buscarPorId(idArticulo);					
					aListArt.add(art);
				}
				
				altaCesta.setImporte(importeCesta);
				// actualizo la cesta con el importe total de todos los articulos 
				serviceCestas.guardarCesta(altaCesta);
				model.addAttribute("cestaActiva", altaCesta);				
			}
		} else {
			ac2 = serviceArticulosCestas.ConsultarIdArticuloCesta(id, cesta.getId());
			if(ac2 != null) {
				attributes.addFlashAttribute("msg","Ya existe el articulo en la cesta");
				return "redirect:/";
			}
			ac.setIdArticulo(id);
			ac.setIdCesta(cesta.getId());
			ac.setCantidad(1);
			ac.setImporte(articulo.getPrecio());

			serviceArticulosCestas.altaArticuloCesta(ac);
			
			List<ArticuloCesta> listAc = serviceArticulosCestas.buscarArticulos(cesta.getId());					
			
			for (ArticuloCesta artC : listAc) {
				Articulo art = new Articulo();
				int idArticulo = artC.getIdArticulo();
				numArticulos = numArticulos + 1;				
				importeCesta = importeCesta + artC.getImporte(); 
				art = serviceArticulos.buscarPorId(idArticulo);				
				aListArt.add(art);
			}
			cesta.setImporte(importeCesta);
			// actualizo la cesta con el importe total de todos los articulos 
			serviceCestas.guardarCesta(cesta);
			model.addAttribute("cestaActiva", cesta);						
		}		
		
		model.addAttribute("articulos", aListArt);	
		model.addAttribute("numArticulos", numArticulos);
		model.addAttribute("userId", UsuarioController.userId);
		model.addAttribute("userNombre", UsuarioController.userNombre);
		
		return "redirect:/cesta/index";			
	}
	
	@GetMapping("/articulo/cesta/delete")
	public String eliminarAc(@RequestParam("idArticulo") Integer idArticulo, @RequestParam("idCesta") Integer idCesta,
							RedirectAttributes attributes, Model model) {
		
			
		Cesta cestaActiva = new Cesta();				
		ArticuloCesta ac= new ArticuloCesta();		
	 	ac = serviceArticulosCestas.ConsultarIdArticuloCesta(idArticulo, idCesta);	
	 	int idAc = ac.getId();
	 		 	
		serviceArticulosCestas.eliminarAc(idAc);
		attributes.addFlashAttribute("msg","El articulo ha sido eliminado!");
		cestaActiva.setId(idAc);
		return "redirect:/cesta/index";	
		
	} 
	 
}



