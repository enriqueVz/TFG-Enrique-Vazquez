package airsoftspain.proyect.daos;

import java.sql.Date;
import java.util.List;

import airsoftspain.proyect.entities.Pedido;

public interface PedidoDao {

	// Buscar pedido por "ID de pedido"
	public Pedido findPorId(int idPed);

	// Buscar pedido por "idUser"
	public Pedido findPorIdUser(int idUser);
	
	// Buscar pedido por "total del pedido"
	public Pedido findPorTotal(double total);
	
	// Buscar pedido por "fecha"
	public Pedido findPorFecha(Date fechaped);

	// Métodos del CRUD
	public List<Pedido> listarLosPedidos();

	public Pedido guardarPedido(Pedido pedido);

	public Pedido modificarPedido(Pedido pedido);

	public void eliminarPedido(int id);

}
