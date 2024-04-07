package airsoftspain.proyect.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsoftspain.proyect.entities.Productos;
import airsoftspain.proyect.repositories.ProductosRepository;

@Service
public class ProductosDaoImpl implements ProductosDao {

	@Autowired
	ProductosRepository Prepo;
	
	@Override
	public List<Productos> findProductos() {
		return Prepo.findAll();
	}

	@Override
	public Productos findProductosPorId(int id) {
		return Prepo.buscarProductosPorId(id);
	}

	@Override
	public List<Productos> findbByTiposProd(int tipo_prod) {
		return Prepo.buscarProdXTipos(tipo_prod);
	}

	@Override
	public List<Productos> findByNombre(String nombre_p) {
		return Prepo.productosXNombre(nombre_p);
	}

	@Override
	public List<Productos> findProductosByEtiquetas(int etiquetas) {
		return Prepo.buscarProdXEtiquetas(etiquetas);
	}

	@Override
	public List<Productos> findProductosByStock(int stock) {
		return Prepo.buscarProdXStock(stock);
	}

}
