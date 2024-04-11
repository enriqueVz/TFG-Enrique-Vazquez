package airsoftspain.proyect.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsoftspain.proyect.entities.Producto;
import airsoftspain.proyect.repositories.ProductoRepository;

//Indicamos que es un servicio
@Service
public class ProductoDaoImpl implements ProductoDao {

	//Importamos las querys de repositorio de producto
	@Autowired
	ProductoRepository Prepo;
	

	// Método para buscar los productos por "ID"
	@Override
	public Producto findProductosPorId(int id) {
		return Prepo.buscarProductosPorId(id);
	}

	// Método para buscar los productos por "tipo de rol
	@Override
	public List<Producto> findbByTiposProd(int tipoProd) {
		return Prepo.buscarProdXTipos(tipoProd);
	}

	// Método para buscar los productos por "nombre"
	@Override
	public List<Producto> findByNombre(String nombre) {
		return Prepo.productosXNombre(nombre);
	}

	// Método para buscar los productos por "etiquetas"
	@Override
	public List<Producto> findProductosByEtiquetas(int etiquetas) {
		return Prepo.buscarProdXEtiquetas(etiquetas);
	}
	// Método para buscar los productos por "stock"
	@Override
	public List<Producto> findProductosByStock(int stock) {
		return Prepo.buscarProdXStock(stock);
	}
	// Método para buscar los productos por "material"
	@Override
	public List<Producto> findProductosByMaterial(String material) {
		return Prepo.buscarProdXMaterial(material);
	}

	// Método para buscar los productos por "fabricante"
	@Override
	public List<Producto> findProductosByFabricante(String fabricante) {
		return Prepo.buscarProdXFabricante(fabricante);
	}

	// Método para buscar los productos por "mecanismo"
	@Override
	public List<Producto> findProductosByMecanismo(String mecanismo) {
		return Prepo.buscarProdXMecanismo(mecanismo);
	}
	
	//Métodos del CRUD	
	// Método para buscar todos los productos (usamos el método existente ".findAll")
	@Override
	public List<Producto> findProductos() {
		return Prepo.findAll();
	}

	// Método para dar de alta a un producto
	@Override
	public Producto guardarProducto(Producto producto) {
		return Prepo.save(producto);
	}

	// Método para modificar un producto
	@Override
	public Producto modificarProducto(Producto producto) {
		return Prepo.save(producto);
	}

	// Método para eliminar un producto
	@Override
	public void eliminarProducto(int id) {
		Prepo.deleteById(id);
	}


}
