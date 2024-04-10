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

@Controller
public class EtiquetaController {

	@Autowired
	EtiquetaDao edao;
	
	
	@GetMapping("/etiquetas")
	public String verLosRoles(Model model) {
		model.addAttribute("etiquetas", edao.listarLasEtiquetas());
		return "etiquetas";
	
	}
	
	//FALLA ALGOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
	@GetMapping("/etiquetas/etiqueta/{id}")
	public String verUnRol(@PathVariable("id") String nombre, Model model){
		model.addAttribute("etiqueta", edao.findPorNombre(nombre));
		return "etiqueta";
		
	}//No funciona)
	
	@GetMapping("/etiquetas/alta")
	public String altaEtiquetaForm(Model model) {
		Etiqueta etiqueta = new Etiqueta();
		model.addAttribute("etiqueta", etiqueta);
		return "etiquetacrear";
	
	}
	
	@PostMapping("/etiquetas")
	public String procesarAltaUser(@ModelAttribute("etiqueta") Etiqueta etiqueta) {
		edao.guardarEtiqueta(etiqueta);
		return "redirect:/etiquetas";
		
	}
	
	@GetMapping("/etiquetas/modificar/{id}")
	public String mostrarEtiquetaEdit(@PathVariable int id, Model model) {
	model.addAttribute("etiqueta", edao.findPorId(id));
	return "etiquetamodif";
}
	
	@PostMapping("/etiquetas/{id}")
	public String modificarEtiqueta(@PathVariable int id, @ModelAttribute("etiqueta") Etiqueta etiqueta, Model model) {
		Etiqueta etiquetaExistente = edao.findPorId(id);
		
		etiquetaExistente.setNombre(etiqueta.getNombre());
		
		edao.modificarEtiqueta(etiquetaExistente);
		return "redirect:/etiquetas";
		
	}
	
	//DELETE
	@GetMapping("/etiquetas/eliminar/{id}")
	public String eliminarEtiqueta(@PathVariable int id) {
	edao.eliminarEtiqueta(id);
		return "redirect:/etiquetas";
	}
	
	
	
}
