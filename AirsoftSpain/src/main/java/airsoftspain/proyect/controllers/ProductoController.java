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

//Indicamos que es un controlador
@Controller
public class ProductoController {

	// Importamos las querys de repositorio de etiqueta
	@Autowired
	ProductoDao pdao;

	@GetMapping("/productos")
	// Método para ver los productos en esta URL
	public String verLosProds(Model model) {
		// Con el model asignamos la palabra para buscar en la base de datos desde el
		// HTML
		model.addAttribute("productos", pdao.findProductos());
		return "productos";
	}

	/*
	 * @GetMapping("/productos/producto/") public String
	 * verUnProd(@PathVariable("id") int id, Model model) {
	 * model.addAttribute("producto", pdao.findProductosPorId(id)); return
	 * "producto"; }
	 */

	@GetMapping("/productos/alta")
	// Método para dar de alta un producto en esta URL
	public String altaProductoForm(Model model) {
		// Creamos un nuevo objeto Producto
		Producto producto = new Producto();
		// Vinculamos el model "producto" del HTML con la nueva etiqueta vacía.
		model.addAttribute("producto", producto);
		return "productocrear";
	}

	// PostMapping para el tratamiento de datos
	@PostMapping("/productos")
	// Método para guardar la información introducida en la web
	public String ProcesarAltaProducto(@ModelAttribute("producto") Producto producto) {
		// Guardamos la etiqueta mediante "pdao"
		pdao.guardarProducto(producto);
		return "redirect:/productos";

	}

	@GetMapping("/productos/modificar/{id}")
	// Método para modificar una etiqueta mediante en la web
	public String modificarProducto(@PathVariable int id, Model model) {
		// Asignamos la id de la etiqueta a "etiqueta" para invocarlo en el HTML
		model.addAttribute("producto", pdao.findProductosPorId(id));
		return "productomodif";
	}

	// PostMapping para el tratamiento de datos
	@PostMapping("/productos/{id}")
	// Método para sobreescribir el usuario existente
	public String modificarUser(@PathVariable int id, @ModelAttribute("producto") Producto producto, Model model) {
		// La variable "prodExistente" recogerá los datos asignados a la id
		// introducida para su posterior modificación
		Producto prodExistente = pdao.findProductosPorId(id);

		// Modificamos los camos con getters y setters, y con Thymeleaf recogemos el input del admin
		prodExistente.setId(id);
		prodExistente.setNombre(producto.getNombre());
		prodExistente.setDescripcion(producto.getDescripcion());
		prodExistente.setEtiquetas(producto.getEtiquetas());
		prodExistente.setPrecio(producto.getPrecio());
		prodExistente.setStock(producto.getStock());
		prodExistente.setTipoProd(producto.getTipoProd());
		prodExistente.setMaterial(producto.getMaterial());
		prodExistente.setFabricante(producto.getFabricante());
		prodExistente.setMecanismo(producto.getMecanismo());

		// Llamamos al método que guarda la modificación
		pdao.modificarProducto(prodExistente);
		return "redirect:/productos";
	}

	@GetMapping("/productos/eliminar/{id}")
	// Método para eliminar etiquetas segun la id seleccionada
	public String eliminarProducto(@PathVariable int id) {
		pdao.eliminarProducto(id);
		return "redirect:/productos";
	}
}
