package airsoftspain.proyect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import airsoftspain.proyect.daos.UsuarioDao;
import airsoftspain.proyect.entities.Usuario;

@Controller
public class UsuarioController {
	

	//MIRAR PARA HACER RUTA PREDETERMINADA	
@Autowired
UsuarioDao udao;

	@GetMapping("/usuarios")
	public String verLosUsers(Model model) {
		model.addAttribute("usuarios", udao.verLosUsuarios());
		return "usuarios";
		
	}
	
	@GetMapping("/usuarios/user/{dni}")
	public String verUnUser(@PathVariable("dni") String dni, Model model){
		model.addAttribute("usuario", udao.buscarPorDNI(dni));
		return "user";
		
	}//No funciona)
	
	
	@GetMapping("/usuarios/alta")
	public String altaUsuarioForm(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "usercrear";
		
	}
	@PostMapping("/usuarios")
	public String procesarAltaUser(@ModelAttribute("usuario") Usuario usuario) {
		udao.guardarUser(usuario);
		return "redirect:/usuarios";
		
	}
}

