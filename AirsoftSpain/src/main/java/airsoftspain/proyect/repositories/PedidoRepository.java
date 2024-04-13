package airsoftspain.proyect.repositories;

import java.sql.Date;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import airsoftspain.proyect.entities.Pedido;

//Indicamos que es un repositorio
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	// Query para filtrar pedidos por el campo "idPed"
	@Query("SELECT p from Pedido p WHERE p.idPed=?1")
	public Pedido encontrarPedidoXId(int idPed);

	// Query para filtrar etiquetas por el campo "idUser"
	@Query("SELECT p from Pedido p WHERE p.idUser=?1")
	public Pedido encontrarPedidoXidUser(int idUser);

	// Query para filtrar etiquetas por el campo "fecha"
	@Query("SELECT p from Pedido p WHERE p.fechaped=?1")
	public Pedido encontrarPedidoXFecha(Date fechaped);

	// Query para filtrar etiquetas por el campo "total del pedido"
	@Query("SELECT p from Pedido p WHERE p.total=?1")
	public Pedido encontrarPedidoXTotal(double total);

}
