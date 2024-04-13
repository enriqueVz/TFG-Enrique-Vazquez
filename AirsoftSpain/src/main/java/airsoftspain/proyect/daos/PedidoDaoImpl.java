package airsoftspain.proyect.daos;

import java.sql.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsoftspain.proyect.entities.Pedido;
import airsoftspain.proyect.repositories.PedidoRepository;


//Indicamos que es un servicio
@Service
public class PedidoDaoImpl implements PedidoDao {

	// Importamos las querys de repositorio de rol
	@Autowired
	 PedidoRepository prepo;

	// Método para buscar los pedidos por "ID"
	@Override
	public Pedido findPorId(int idPed) {
		return prepo.findById(idPed).orElse(null);
	}

	// Método para buscar los pedidos por "ID del usuario"
	@Override
	public Pedido findPorIdUser(int idUser) {
		return prepo.encontrarPedidoXidUser(idUser);
	}
	
	// Método para buscar los pedidos por "el total del pedido"
		@Override
		public Pedido findPorTotal(double total) {
			return prepo.encontrarPedidoXTotal(total);
		}
		
	// Método para buscar los pedidos por "fecha"
			@Override
			public Pedido findPorFecha(Date fecha) {
				return prepo.encontrarPedidoXFecha(fecha);
		}

		
	//Métodos del CRUD
	// Método para buscar todos los pedidos (usamos el método existente ".findAll")
	@Override
	public List<Pedido> listarLosPedidos() {
		return prepo.findAll();
	}

	//Método para crear un pedido
	@Override
	public Pedido guardarPedido(Pedido pedido) {
		return prepo.save(pedido);
	}

	// Método para modificar un Pedido
	@Override
	public Pedido modificarPedido(Pedido pedido) {
		return prepo.save(pedido);
	}

	// Método para eliminar un rol
	@Override
	public void eliminarPedido(int idPed) {
		prepo.deleteById(idPed);
	}

}
