package airsoftspain.proyect.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import airsoftspain.proyect.daos.RolDao;
import airsoftspain.proyect.entities.Rol;


@Controller
public class RolController {

	
	@Autowired
	RolDao rdao;
	
	@GetMapping("/roles")
	public String verLosRoles(Model model) {
		model.addAttribute("roles", rdao.filtrarRoles());
		return "roles";
	
	}
	
	//FALLA ALGOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
		@GetMapping("/roles/rol/{id}")
		public String verUnRol(@PathVariable("id") String nombre, Model model){
			model.addAttribute("rol", rdao.VerRolPorNombre(nombre));
			return "rol";
			
		}//No funciona)

		@GetMapping("/roles/alta")
		public String altaUsuarioForm(Model model) {
			Rol rol = new Rol();
			model.addAttribute("rol", rol);
			return "rolcrear";
		
		}
		
		@PostMapping("/roles")
		public String procesarAltaUser(@ModelAttribute("rol") Rol rol) {
			rdao.guardarRol(rol);
			return "redirect:/roles";
			
		}
		
		@GetMapping("/roles/modificar/{id}")
		public String mostrarFormEdit(@PathVariable int id, Model model) {
		model.addAttribute("rol", rdao.verElRol(id));
		return "rolmodif";
	}
	
		@PostMapping("/roles/{id}")
		public String modificarRol(@PathVariable int id, @ModelAttribute("rol") Rol rol, Model model) {
			Rol rolExistente = rdao.verElRol(id);
			
			rolExistente.setNombre(rol.getNombre());
			rolExistente.setDescripcion(rol.getDescripcion());
			
			rdao.modificarRol(rolExistente);
			return "redirect:/roles";
			
		}
	
		//DELETE
		@GetMapping("/roles/eliminar/{id}")
		public String eliminarRol(@PathVariable int id) {
			rdao.eliminarRol(id);
			return "redirect:/roles";
		}
	
	
	
	
	
	
	
}

