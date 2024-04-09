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
	//FALLA ALGOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
	@GetMapping("/usuarios/user/{id}")
	public String verUnUser(@PathVariable("id") int id, Model model){
		model.addAttribute("usuario", udao.buscarXId(id));
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
	
	@GetMapping("/usuarios/modificar/{id}")
	public String mostrarFormEdit(@PathVariable int id, Model model) {
	model.addAttribute("usuario", udao.buscarXId(id));
	return "usermodif";
}

	@PostMapping("/usuarios/{id}")
	public String modificarUser(@PathVariable int id, @ModelAttribute("usuario") Usuario usuario, Model model) {
		Usuario userExistente = udao.buscarXId(id);
		userExistente.setId(id);
		userExistente.setNombre(usuario.getNombre());
		userExistente.setApellidos(usuario.getApellidos());
		userExistente.setContraseña(usuario.getContraseña());
		userExistente.setCPostal(usuario.getCPostal());
		userExistente.setDireccion(usuario.getDireccion());
		userExistente.setDni(usuario.getDni());
		userExistente.setEmail(usuario.getEmail());
		userExistente.setIdRol(usuario.getIdRol());
		userExistente.setTelefono(usuario.getTelefono());
		
		udao.modificarUser(userExistente);
		return "redirect:/usuarios";
		
	}
	
	//DELETE
	@GetMapping("/usuarios/eliminar/{id}")
	public String eliminarUser(@PathVariable int id) {
		udao.eliminarUser(id);
		return "redirect:/usuarios";
	}
}