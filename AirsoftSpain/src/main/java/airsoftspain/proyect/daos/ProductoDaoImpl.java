package airsoftspain.proyect.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsoftspain.proyect.entities.Producto;
import airsoftspain.proyect.repositories.ProductoRepository;

@Service
public class ProductoDaoImpl implements ProductoDao {

	@Autowired
	ProductoRepository Prepo;
	

	@Override
	public Producto findProductosPorId(int id) {
		return Prepo.buscarProductosPorId(id);
	}

	@Override
	public List<Producto> findbByTiposProd(int tipoProd) {
		return Prepo.buscarProdXTipos(tipoProd);
	}

	@Override
	public List<Producto> findByNombre(String nombre) {
		return Prepo.productosXNombre(nombre);
	}

	@Override
	public List<Producto> findProductosByEtiquetas(int etiquetas) {
		return Prepo.buscarProdXEtiquetas(etiquetas);
	}

	@Override
	public List<Producto> findProductosByStock(int stock) {
		return Prepo.buscarProdXStock(stock);
	}
	
	//CRUD
	
	@Override
	public List<Producto> findProductos() {
		return Prepo.findAll();
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		return Prepo.save(producto);
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		return Prepo.save(producto);
	}

	@Override
	public void eliminarProducto(int id) {
		Prepo.deleteById(id);
	}

}
