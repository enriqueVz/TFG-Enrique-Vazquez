package airsoftspain.proyect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import airsoftspain.proyect.daos.EtiquetaDao;
import airsoftspain.proyect.entities.Etiqueta;

//Indicamos que es un controlador
@Controller
public class EtiquetaController {

	// Importamos las querys de repositorio de etiqueta
	@Autowired
	EtiquetaDao edao;

	@GetMapping("/etiquetas")
	// Método para ver las etiquetas en esta URL
	public String verLosRoles(Model model) {
		// Con el model asignamos la palabra para buscar en la base de datos desde el
		// HTML
		model.addAttribute("etiquetas", edao.listarLasEtiquetas());
		return "etiquetas";

	}

	/*
	 * //FALLA ALGOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
	 * 
	 * @GetMapping("/etiquetas/etiqueta/{id}") public String
	 * verUnRol(@PathVariable("id") String nombre, Model model){
	 * model.addAttribute("etiqueta", edao.findPorNombre(nombre)); return
	 * "etiqueta";
	 * 
	 * }//No funciona)
	 */

	@GetMapping("/etiquetas/alta")
	// Método para dar de alta una etiqueta en esta URL
	public String altaEtiquetaForm(Model model) {
		// Creamos un nuevo objeto Etiqueta
		Etiqueta etiqueta = new Etiqueta();
		// Vinculamos el model "etiqueta" del HTML con la nueva etiqueta vacía.
		model.addAttribute("etiqueta", etiqueta);
		return "etiquetacrear";

	}

	// PostMapping para el tratamiento de datos
	@PostMapping("/etiquetas")
	// Método para guardar la información introducida en la web
	public String procesarAltaUser(@ModelAttribute("etiqueta") Etiqueta etiqueta) {
		// Guardamos la etiqueta mediante "edao"
		edao.guardarEtiqueta(etiqueta);
		return "redirect:/etiquetas";

	}

	@GetMapping("/etiquetas/modificar/{id}")
	// Método para modificar una etiqueta mediante en la web
	public String mostrarEtiquetaEdit(@PathVariable int id, Model model) {
		// Asignamos la id de la etiqueta a "etiqueta" para invocarlo en el HTML
		model.addAttribute("etiqueta", edao.findPorId(id));
		return "etiquetamodif";
	}

	// PostMapping para el tratamiento de datos
	@PostMapping("/etiquetas/{id}")
	// Método para sobreescribir la etiqueta existente
	public String modificarEtiqueta(@PathVariable int id, @ModelAttribute("etiqueta") Etiqueta etiqueta, Model model) {
		// La variable "etiquetaExistente" recogerá los datos asignados a la id
		// introducida para su posterior modificación
		Etiqueta etiquetaExistente = edao.findPorId(id);
		
		// Modificamos los camos con getters y setters, y con Thymeleaf recogemos el imput del admin
		etiquetaExistente.setNombre(etiqueta.getNombre());
		// Llamamos al método que guarda la modificación
		edao.modificarEtiqueta(etiquetaExistente);
		return "redirect:/etiquetas";

	}

	@GetMapping("/etiquetas/eliminar/{id}")
	// Método para eliminar etiquetas segun la id seleccionada
	public String eliminarEtiqueta(@PathVariable int id) {
		// Llamamos a la variable que elimina la etiqueta
		edao.eliminarEtiqueta(id);
		return "redirect:/etiquetas";
	}

}
