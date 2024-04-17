package airsoftspain.proyect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import airsoftspain.proyect.daos.PedidoDao;
import airsoftspain.proyect.entities.Pedido;


@Controller
public class PedidoController {
	// Importamos las querys de repositorio de pedido
		@Autowired
		PedidoDao pdao;

		@GetMapping("/pedidos")
		// Método para ver los pedidos en esta URL
		public String verLosPedidos(Model model) {
			// Con el model asignamos la palabra para buscar en la base de datos desde el
			// HTML
			model.addAttribute("pedidos", pdao.listarLosPedidos());
			return "pedidos";

		}

		/*
		 * //FALLA ALGOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
		 * 
		 * @GetMapping("/pedidos/pedido/{id}") public String
		 * verUnPedido(@PathVariable("idPed") int idPed, Model model){
		 * model.addAttribute("pedido", edao.findPorIdPed(idPed)); return
		 * "pedido";
		 * 
		 * }//No funciona)
		 */

		@GetMapping("/pedidos/alta")
		// Método para dar de alta un pedido en esta URL
		public String altaEFormPedidos(Model model) {
			// Creamos un nuevo objeto Pedido
			Pedido pedido = new Pedido();
			// Vinculamos el model "pedido" del HTML con el nuevo pedido vacío.
			model.addAttribute("pedido", pedido);
			return "pedidocrear";

		}

		// PostMapping para el tratamiento de datos
		@PostMapping("/pedidos")
		// Método para guardar la información introducida en la web
		public String procesarAltaPediod(@ModelAttribute("pedido") Pedido pedido) {
			// Guardamos el pedido mediante "pdao"
			pdao.guardarPedido(pedido);
			return "redirect:/pedidos";

		}

		@GetMapping("/pedidos/modificar/{idPed}")
		// Método para modificar un pedido mediante en la web
		public String mostrarPedidoEdit(@PathVariable int idPed, Model model) {
			// Asignamos la id del pedido a "pedido" para invocarlo en el HTML
			model.addAttribute("pedido", pdao.findPorId(idPed));
			return "pedidomodif";
		}

		// PostMapping para el tratamiento de datos
		@PostMapping("/pedidos/{idPed}")
		// Método para sobreescribir el pedido existente
		public String modificarPedido(@PathVariable int idPed, int idUser, @ModelAttribute("pedido") Pedido pedido, Model model) {
			// La variable "pedExistente" recogerá los datos asignados a la id
			// introducida para su posterior modificación
			Pedido pedExistente = pdao.findPorId(idPed);
			
			// Modificamos los campos con getters y setters, y con Thymeleaf recogemos el imput del admin
			pedExistente.setIdPed(pedido.getIdPed());
			pedExistente.setTotal(pedido.getTotal());
			pedExistente.setFechaped(pedido.getFechaped());
			pedExistente.setIdUser(idUser);
			
			// Llamamos al método que guarda la modificación
	pdao.modificarPedido(pedExistente);
			return "redirect:/pedidos";

		}

		@GetMapping("/pedidos/eliminar/{idPed}")
		// Método para eliminar pedidos segun la id seleccionada
		public String eliminarPedido(@PathVariable int idPed) {
			// Llamamos a la variable que elimina el pedido
			pdao.eliminarPedido(idPed);
			return "redirect:/pedidos";
		}

	}
