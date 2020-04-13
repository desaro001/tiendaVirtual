package com.arturo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arturo.model.Usuario;
import com.arturo.service.IUsuariosService;

@Controller
public class UsuarioController {
	
	public static int userId = 0;
	public static String userNombre = "";
	
	@Autowired
	private IUsuariosService serviceUsuarios;
	
	@PostMapping("/signup")	
	public String guardarUsuario(   Usuario usuario,
									@RequestParam("nombre") String nombre,
									@RequestParam("email") String email,	
									@RequestParam("username") String username,
									@RequestParam("password") String password,
									RedirectAttributes attributes,
									Model model			
								) {
		
		System.out.println("Arrancando alta de usuario...");
		Date myDate = new Date();
		usuario.setFechaRegistro(myDate);
		String status = "R";
		usuario.setEstatus(status);		
		System.out.println("Alta del usuario..."+usuario.toString());	
		System.out.println("Username del usuario..."+usuario.getUsername());
		serviceUsuarios.guardarUsuario(usuario);
		attributes.addFlashAttribute("msg","usuario registrado correctamente !");
		
		return "redirect:/";			
	}
	
	@GetMapping("/signup")	
	public String mostrarFormulario(Model model, Usuario usuario) {		
		
		model.addAttribute("usuario", usuario);
		return "formRegistro";
	}
	
	@PostMapping("/entrar")	
	public String ingresarUsuario(   
			Usuario usuario,			
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			RedirectAttributes attributes,
			Model model			
		) {		
		
		usuario = serviceUsuarios.buscarUsuario(username, password);
		if(usuario == null) {
			attributes.addFlashAttribute("msg","El usuario o la password no son correctas");
			return "entrar";
		}		
		
		userId =usuario.getId();
		userNombre = usuario.getNombre();
		return "redirect:/";		
	}
	
	@GetMapping("/entrar")	
	public String mostrarFormEntrar(Model model, Usuario usuario) {		
		
		model.addAttribute("usuario", usuario);
		return "entrar";
	}

}
