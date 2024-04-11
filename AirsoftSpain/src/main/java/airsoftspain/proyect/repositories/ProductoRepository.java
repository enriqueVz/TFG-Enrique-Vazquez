package airsoftspain.proyect.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import airsoftspain.proyect.entities.Producto;

//Indicamos que es un repositorio
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	//Query para filtrar productos por el campo "id"
	@Query("SELECT p FROM Producto p WHERE p.id=?1")
	public Producto buscarProductosPorId(int id);
	
	//Query para filtrar productos por el campo "nombre"
	@Query("SELECT p FROM Producto p WHERE p.nombre=?1")
	public List<Producto> productosXNombre(String nombre);

	//Query para filtrar productos por el campo "precio"
	@Query("SELECT p FROM Producto p WHERE p.precio<=?1")
	public List<Producto> buscarProductosXPrecioIGoMEN(double precio);

	//Query para filtrar productos por el campo "etiquetas"
	@Query("Select p FROM Producto p WHERE p.etiquetas=?1")
	public List<Producto> buscarProdXEtiquetas(int etiquetas);

	//Query para filtrar productos por el campo "stock"
	@Query("Select p FROM Producto p WHERE p.stock=?1")
	public List<Producto> buscarProdXStock(int stock);

	//Query para filtrar productos por el campo "tipo de producto"
	@Query("Select p FROM Producto p WHERE p.tipoProd=?1")
	public List<Producto> buscarProdXTipos(int tipoProd);

	//Query para filtrar productos por el campo "material"
	@Query("Select p FROM Producto p WHERE p.material=?1")
	public List<Producto> buscarProdXMaterial(String material);

	//Query para filtrar productos por el campo "fabricante"
	@Query("Select p FROM Producto p WHERE p.fabricante=?1")
	public List<Producto> buscarProdXFabricante(String fabricante);

	//Query para filtrar productos por el campo "mecanismo"
	@Query("Select p FROM Producto p WHERE p.mecanismo=?1")
	public List<Producto> buscarProdXMecanismo(String mecanismo);
}
