package airsoftspain.proyect.daos;

import java.util.List;

import airsoftspain.proyect.entities.Productos;

public interface ProductosDao {
	
	List<Productos> findProductos();
	Productos findProductosPorId(int id);
	List<Productos> findbByTiposProd(int tipo_prod);
	List<Productos> findByNombre(String nombre_p);
	List<Productos> findProductosByEtiquetas (int etiquetas);
	List<Productos> findProductosByStock (int stock);

}
