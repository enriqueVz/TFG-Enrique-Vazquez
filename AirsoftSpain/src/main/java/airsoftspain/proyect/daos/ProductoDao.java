package airsoftspain.proyect.daos;

import java.util.List;


import airsoftspain.proyect.entities.Producto;

public interface ProductoDao {
	
	
	Producto findProductosPorId(int id);
	public List<Producto> findbByTiposProd(int tipoProd);
	public List<Producto> findByNombre(String nombre);
	public List<Producto> findProductosByEtiquetas (int etiquetas);
	public List<Producto> findProductosByStock (int stock);
	
	//CRUD
	public List<Producto> findProductos();
	public Producto guardarProducto(Producto producto);
	public Producto modificarProducto(Producto producto);
	public void eliminarProducto (int id);

}
