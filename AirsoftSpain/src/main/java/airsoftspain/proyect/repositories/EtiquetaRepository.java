package airsoftspain.proyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import airsoftspain.proyect.entities.Etiqueta;

//Indicamos que es un repositorio
@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Integer> {

	//Query para filtrar etiquetas por el campo "id"
	@Query("SELECT e FROM Etiqueta e WHERE e.id=?1")
	public Etiqueta findEtiquetabyID(int id);

	//Query para filtrar etiquetas por el campo "nombre"
	@Query("SELECT e FROM Etiqueta e WHERE e.nombre=?1")
	public Etiqueta findEtiquetabyNombre(String nombre);

}