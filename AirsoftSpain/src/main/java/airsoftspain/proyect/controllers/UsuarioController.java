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

//Indicamos que es un controlador
@Controller
public class UsuarioController {

// Importamos las querys de repositorio de usuario
	@Autowired
	UsuarioDao udao;

	@GetMapping("/usuarios")
	// Método para ver las usuarios en esta URL
	public String verLosUsers(Model model) {
		// Con el model asignamos la palabra para buscar en la base de datos desde el
		// HTML
		model.addAttribute("usuarios", udao.verLosUsuarios());
		return "usuarios";

	}
	/*
	 * //FALLA ALGOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
	 * 
	 * @GetMapping("/usuarios/user/{id}") public String
	 * verUnUser(@PathVariable("id") int id, Model model){
	 * model.addAttribute("usuario", udao.buscarXId(id)); return "user";
	 * 
	 * }//No funciona)
	 */

	@GetMapping("/usuarios/alta")
	// Método para dar de alta un usuario en esta URL
	public String altaUsuarioForm(Model model) {
		// Creamos un nuevo objeto Usuario
		Usuario usuario = new Usuario();
		// Vinculamos el model "usuario" del HTML con la nueva etiqueta vacía.
		model.addAttribute("usuario", usuario);
		return "usercrear";

	}

	// PostMapping para el tratamiento de datos
	@PostMapping("/usuarios")
	// Método para guardar la información introducida en la web
	public String procesarAltaUser(@ModelAttribute("usuario") Usuario usuario) {
		// Guardamos la etiqueta mediante "udao"
		udao.guardarUser(usuario);
		return "redirect:/usuarios";

	}

	@GetMapping("/usuarios/modificar/{id}")
	// Método para modificar un usuario mediante en la web
	public String mostrarFormEdit(@PathVariable int id, Model model) {
		// Asignamos la id del usuario a "usuario" para invocarlo en el HTML
		model.addAttribute("usuario", udao.buscarXId(id));
		return "usermodif";
	}

	// PostMapping para el tratamiento de datos
	@PostMapping("/usuarios/{id}")
	// Método para sobreescribir el usuario existente
	public String modificarUser(@PathVariable int id, @ModelAttribute("usuario") Usuario usuario, Model model) {
		// La variable "userExistente" recogerá los datos asignados a la id
		// introducida para su posterior modificación
		Usuario userExistente = udao.buscarXId(id);

		// Modificamos los camos con getters y setters, y con Thymeleaf recogemos el
		// imput del admin
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

		// Llamamos al método que guarda la modificación
		udao.modificarUser(userExistente);
		return "redirect:/usuarios";

	}

	// DELETE
	@GetMapping("/usuarios/eliminar/{id}")
	// Método para eliminar etiquetas segun la id seleccionada
	public String eliminarUser(@PathVariable int id) {
		// Llamamos a la variable que elimina la etiqueta
		udao.eliminarUser(id);
		return "redirect:/usuarios";
	}
}