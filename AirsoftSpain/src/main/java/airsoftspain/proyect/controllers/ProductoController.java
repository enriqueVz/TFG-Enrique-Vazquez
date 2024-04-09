package airsoftspain.proyect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import airsoftspain.proyect.daos.ProductoDao;
import airsoftspain.proyect.entities.Producto;

@Controller
public class ProductoController {

	@Autowired
	ProductoDao pdao;
	
	
	@GetMapping("/productos")
	public String verLosProds(Model model) {
		model.addAttribute("productos", pdao.findProductos());
		return "productos";
	}
	
	/////////////////////////////MIRAR PQ COÑO NO FUNCIONA 
	@GetMapping("/productos/producto/")
	public String verUnProd(@PathVariable("id") int id, Model model) {
		model.addAttribute("producto", pdao.findProductosPorId(id));
		return "producto";
	}
	
	@GetMapping("/productos/alta")
	public String altaProductoForm(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		return "productocrear";
	}
	
	@PostMapping("/productos")
	public String ProcesarAltaProducto(@ModelAttribute("producto") Producto producto) {
		pdao.guardarProducto(producto);
		return "redirect:/productos";
		
	}
	
	@GetMapping("/productos/modificar/{id}")
	public String modificarProducto(@PathVariable int id, Model model) {
		model.addAttribute("producto", pdao.findProductosPorId(id));
		return "productomodif";
	}
	
	@PostMapping("/productos/{id}")
	public String modificarUser(@PathVariable int id, @ModelAttribute("producto") Producto producto, Model model) {
	Producto prodExistente = pdao.findProductosPorId(id);
	//asignación de variables
	
	//ID invariable
		prodExistente.setId(id);
		prodExistente.setNombre(producto.getNombre());
		prodExistente.setDescripcion(producto.getDescripcion());
		prodExistente.setEtiquetas(producto.getEtiquetas());
		prodExistente.setPrecio(producto.getPrecio());
		prodExistente.setStock(producto.getStock());
		prodExistente.settipoProd(producto.gettipoProd());
	
		pdao.modificarProducto(prodExistente);
		return "redirect:/productos";
	}
	
	
	@GetMapping("/productos/eliminar/{id}")
	public String eliminarProducto(@PathVariable int id) {
		pdao.eliminarProducto(id);
		return "redirect:/productos";
	}
}
