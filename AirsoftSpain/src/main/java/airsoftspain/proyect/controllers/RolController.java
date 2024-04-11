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

//Indicamos que es un controlador
@Controller
public class RolController {

	// Importamos las querys de repositorio de rol

	@Autowired
	RolDao rdao;

	@GetMapping("/roles")
	// Método para ver las etiquetas en esta URL
	public String verLosRoles(Model model) {
		// Con el model asignamos la palabra para buscar en la base de datos desde el
		// HTML
		model.addAttribute("roles", rdao.filtrarRoles());
		return "roles";

	}
	/*
	 * //FALLA ALGOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
	 * 
	 * @GetMapping("/roles/rol/{id}") public String verUnRol(@PathVariable("id")
	 * String nombre, Model model){ model.addAttribute("rol",
	 * rdao.VerRolPorNombre(nombre)); return "rol";
	 * 
	 * }//No funciona)
	 */

	@GetMapping("/roles/alta")
	// Método para dar de alta un rol en esta URL
	public String altaUsuarioForm(Model model) {
		// Creamos un nuevo objeto Rol
		Rol rol = new Rol();
		// Vinculamos el model "rol" del HTML con la nueva etiqueta vacía.
		model.addAttribute("rol", rol);
		return "rolcrear";

	}

	// PostMapping para el tratamiento de datos
	@PostMapping("/roles")
	// Método para guardar la información introducida en la web
	public String procesarAltaUser(@ModelAttribute("rol") Rol rol) {
		// Guardamos la etiqueta mediante "rdao"
		rdao.guardarRol(rol);
		return "redirect:/roles";

	}

	@GetMapping("/roles/modificar/{id}")
	// Método para modificar una etiqueta mediante en la web
	public String mostrarFormEdit(@PathVariable int id, Model model) {
		// Asignamos la id de la etiqueta a "rol" para invocarlo en el HTML
		model.addAttribute("rol", rdao.verElRol(id));
		return "rolmodif";
	}

	// PostMapping para el tratamiento de datos
	@PostMapping("/roles/{id}")
	// Método para sobreescribir el rol existente
	public String modificarRol(@PathVariable int id, @ModelAttribute("rol") Rol rol, Model model) {
		// La variable "rolExistente" recogerá los datos asignados a la id
		// introducida para su posterior modificación
		Rol rolExistente = rdao.verElRol(id);

		// Modificamos los camos con getters y setters, y con Thymeleaf recogemos el
		// imput del admin
		rolExistente.setNombre(rol.getNombre());
		rolExistente.setDescripcion(rol.getDescripcion());

		// Llamamos al método que guarda la modificación
		rdao.modificarRol(rolExistente);
		return "redirect:/roles";

	}

	@GetMapping("/roles/eliminar/{id}")
	// Método para eliminar etiquetas segun la id seleccionada
	public String eliminarRol(@PathVariable int id) {
		// Llamamos a la variable que elimina la etiqueta
		rdao.eliminarRol(id);
		return "redirect:/roles";
	}

}
