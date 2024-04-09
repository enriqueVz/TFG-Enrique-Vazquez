package airsoftspain.proyect.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import airsoftspain.proyect.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Integer> {

	@Query("SELECT p FROM Producto p WHERE p.id=?1")
	public Producto buscarProductosPorId(int id);
	
	@Query("SELECT p FROM Producto p WHERE p.nombre=?1")
	public List<Producto> productosXNombre(String nombre);
	
	@Query("SELECT p FROM Producto p WHERE p.precio<=?1")
	public List<Producto> buscarProductosXPrecioIGoMEN(double precio);
	
	@Query("Select p FROM Producto p WHERE p.etiquetas=?1")
	public List<Producto> buscarProdXEtiquetas(int etiquetas);
	
	@Query("Select p FROM Producto p WHERE p.stock=?1")
	public List<Producto> buscarProdXStock(int stock);
													//LA variable de la query tiene que ir igual que en Java
	@Query("Select p FROM Producto p WHERE p.tipoProd=?1")
	public List<Producto> buscarProdXTipos(int tipoProd);
}
	
