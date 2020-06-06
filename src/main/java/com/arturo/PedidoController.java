package com.arturo;

import java.util.ArrayList;
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
import com.arturo.model.Pedido;
import com.arturo.model.PedidoArticulo;
import com.arturo.service.IArticulosCestasService;
import com.arturo.service.IArticulosService;
import com.arturo.service.ICestasService;

@Controller
public class PedidoController {

	@Autowired
	private ICestasService serviceCestas;

	@Autowired
	private IArticulosCestasService serviceArticulosCestas;

	@Autowired
	private IArticulosService serviceArticulos;

	private int numArticulos = 0;
	private String tipo = "p";

	@GetMapping("pedido/index")
	public String mostrarPedidos(Model model, RedirectAttributes attributes) {

		numArticulos = 0;
		String tipo = "p";
		List<Pedido> listPedidoswk = new ArrayList<Pedido>();
		List<Cesta> listPedidos = new ArrayList<Cesta>();

		if (UsuarioController.userId == 0) {
			attributes.addFlashAttribute("msg", "para acceder a tus pedidos tienes que entrar con tu usuario");
			return "redirect:/";
		}

		listPedidos = serviceCestas.buscarPedidos(UsuarioController.userId, tipo);
		if (listPedidos.size() == 0) {
			attributes.addFlashAttribute("msg", "no has hecho ningún pedido!");
			return "redirect:/";
		}

		for (Cesta pedido : listPedidos) {

			List<ArticuloCesta> listAc = serviceArticulosCestas.buscarArticulos(pedido.getId());
			List<PedidoArticulo> listpArt = new ArrayList<PedidoArticulo>();
			Pedido pedidoworking = new Pedido();

			for (ArticuloCesta artC : listAc) {
				Articulo art = new Articulo();
				PedidoArticulo Part = new PedidoArticulo();
				int idArt = artC.getIdArticulo();

				art = serviceArticulos.buscarPorId(idArt);
				System.out.println("articulo recuperado...."+art.toString());
				numArticulos = numArticulos + 1;
				Part.setIdPedido(artC.getIdCesta());
				Part.setIdArticulo(artC.getIdArticulo());
				Part.setImagen(art.getImagen());
				Part.setCantidad(artC.getCantidad());
				Part.setDescripcion(art.getDescripcion());
				Part.setPrecio(art.getPrecio());
				System.out.println("pedido articulo recuperado...."+Part.toString());

				listpArt.add(Part);				
			}

			pedidoworking.setIdPedido(pedido.getId());
			pedidoworking.setFechaPedido(pedido.getFecha());
			pedidoworking.setNumArticulos(numArticulos);
			pedidoworking.setImportePedido(pedido.getImporte());
			pedidoworking.setPedidoArticulos(listpArt);
			System.out.println("pedido recuperado...."+pedidoworking.toString());
			listPedidoswk.add(pedidoworking);
		}

		System.out.println("pedido a renderizar...."+listPedidoswk.get(0).toString());
		model.addAttribute("pedidos", listPedidoswk);
		model.addAttribute("userId", UsuarioController.userId);
		model.addAttribute("userNombre", UsuarioController.userNombre);

		return "pedido";
	}

	@GetMapping("pedido/alta")
	public String altaPedido(@RequestParam("idCesta") Integer idCesta, RedirectAttributes attributes, Model model) {

		Cesta cesta = serviceCestas.buscarPorId(idCesta);
		cesta.setTipo(tipo);
		
		// actualizo la cesta con el importe total de todos los articulos 
		serviceCestas.guardarCesta(cesta);
		
		attributes.addFlashAttribute("msg","El pedido ha sido procesado!");		
		return "redirect:/";	

	}
}
