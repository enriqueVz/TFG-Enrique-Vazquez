package airsoftspain.proyect.daos;

import java.util.List;


import airsoftspain.proyect.entities.Producto;

public interface ProductoDao {
	
	
	Producto findProductosPorId(int id);
	public List<Producto> findbByTiposProd(int tipoProd);
	public List<Producto> findByNombre(String nombre);
	public List<Producto> findProductosByEtiquetas (int etiquetas);
	public List<Producto> findProductosByStock(int stock);
	public List<Producto> findProductosByMaterial(String material);
	public List<Producto> findProductosByFabricante(String fabricante);
	public List<Producto> findProductosByMecanismo(String mecanismo);
	
	//CRUD
	public List<Producto> findProductos();
	public Producto guardarProducto(Producto producto);
	public Producto modificarProducto(Producto producto);
	public void eliminarProducto (int id);

}
