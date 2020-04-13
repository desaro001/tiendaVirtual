package com.arturo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arturo.model.Articulo;
import com.arturo.service.IArticulosService;

@Controller
//@RequestMapping(value="/home")
public class HomeControler {

	@Autowired
	private IArticulosService serviceArticulos;		
	
		

	@GetMapping("/")
	public String mostrarHome(Model model) {

		String varTitulo = "OFERTAS DESTACADAS";

		System.out.println("Arrancando mostrarHome...");
		// List<Articulo> lista = serviceArticulos.buscarTodos();
		List<Articulo> lista = serviceArticulos.buscarDestacados("SI");
		for (Articulo articulo : lista) {
			System.out.println(articulo.toString());
		}		
		
		model.addAttribute("articulos", lista);
		model.addAttribute("titulo", varTitulo);
		model.addAttribute("userId", UsuarioController.userId);
		model.addAttribute("userNombre", UsuarioController.userNombre);
		System.out.println("atributo modelo..." + model.getAttribute("articulos").toString());
		return "home";
	}

	@GetMapping("/articulos/polos")
	public String mostrarPolos(Model model) {

		String varTitulo = "POLOS DE HOMBRE";

		System.out.println("Arrancando mostrarPolos...");
		List<Articulo> lista = serviceArticulos.buscarPrenda("POL");
		model.addAttribute("articulos", lista);
		model.addAttribute("titulo", varTitulo);
		model.addAttribute("userId", UsuarioController.userId);
		model.addAttribute("userNombre", UsuarioController.userNombre);
		return "home";
	}

	@GetMapping("/articulos/chaquetas")
	public String mostrarChaquetas(Model model) {

		String varTitulo = "CAZADORAS DE HOMBRE";

		System.out.println("Arrancando mostrarChaquetas...");
		List<Articulo> lista = serviceArticulos.buscarPrenda("CHA");
		model.addAttribute("articulos", lista);
		model.addAttribute("titulo", varTitulo);
		model.addAttribute("userId", UsuarioController.userId);
		model.addAttribute("userNombre", UsuarioController.userNombre);
		return "home";
	}

	@GetMapping("/articulos/pantalones")
	public String mostrarPantalones(Model model) {

		String varTitulo = "PANTALONES DE HOMBRE";

		System.out.println("Arrancando mostrarPantalones...");
		List<Articulo> lista = serviceArticulos.buscarPrenda("PAN");
		model.addAttribute("articulos", lista);
		model.addAttribute("titulo", varTitulo);
		model.addAttribute("userId", UsuarioController.userId);
		model.addAttribute("userNombre", UsuarioController.userNombre);
		return "home"; 
	}

	@GetMapping("/search")
	public String mostrarPrenda(@RequestParam("tipo") int tipo, Model model) {

		if (tipo == 1) {
			mostrarPolos(model);
		} else if (tipo == 2) {
			mostrarPantalones(model);
		} else if (tipo == 3) {
			mostrarChaquetas(model);
		} else {
			mostrarHome(model);
		}
		model.addAttribute("userId", UsuarioController.userId);
		model.addAttribute("userNombre", UsuarioController.userNombre);
		return "home";
	}
	
}