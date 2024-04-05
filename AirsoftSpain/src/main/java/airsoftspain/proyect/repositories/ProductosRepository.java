package airsoftspain.proyect.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import airsoftspain.proyect.entities.Productos;

@Repository
public interface ProductosRepository extends JpaRepository <Productos, Integer> {

	@Query("SELECT p FROM Productos p WHERE p.id=?1")
	public Productos buscarProductosPorId(int id);
	
	@Query("SELECT p FROM Productos p WHERE p.nombre_p=?1")
	public List<Productos> productosXNombre(String nombre_p);
	
	@Query("SELECT p FROM Productos p WHERE p.precio<=?1")
	public List<Productos> buscarProductosXPrecioIGoMEN(double precio);
	
	@Query("Select p FROM Productos p WHERE p.etiquetas=?1")
	public List<Productos> buscarProdXEtiquetas(int etiquetas);
	
	@Query("Select p FROM Productos p WHERE p.stock=?1")
	public List<Productos> buscarProdXStock(int stock);
													//LA variable de la query tiene que ir igual que en Java
	@Query("Select p FROM Productos p WHERE p.tipo_prod=?1")
	public List<Productos> buscarProdXTipos(int tipo_prod);
}
	
