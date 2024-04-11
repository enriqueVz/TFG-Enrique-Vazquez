package airsoftspain.proyect.daos;

import java.util.List;

import airsoftspain.proyect.entities.Producto;

public interface ProductoDao {

	// Buscar productos por "ID"
	Producto findProductosPorId(int id);

	// Buscar productos por "tipo de producto"
	public List<Producto> findbByTiposProd(int tipoProd);

	// Buscar productos por "nombre"
	public List<Producto> findByNombre(String nombre);

	// Buscar productos por "etiquetas"
	public List<Producto> findProductosByEtiquetas(int etiquetas);

	// Buscar productos por "stock"
	public List<Producto> findProductosByStock(int stock);

	// Buscar productos por "material"
	public List<Producto> findProductosByMaterial(String material);

	// Buscar productos por "fabricante"
	public List<Producto> findProductosByFabricante(String fabricante);

	// Buscar productos por "mecanismo"
	public List<Producto> findProductosByMecanismo(String mecanismo);

	// Métodos del CRUD
	public List<Producto> findProductos();

	public Producto guardarProducto(Producto producto);

	public Producto modificarProducto(Producto producto);

	public void eliminarProducto(int id);

}
