package airsoftspain.proyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import airsoftspain.proyect.entities.Etiquetas;

@Repository
public interface EtiquetasRepository extends JpaRepository <Etiquetas, Integer> {

	@Query("SELECT e FROM Etiquetas e WHERE e.id=?1")
	public Etiquetas findEtiquetabyID(int id);
	
	@Query("SELECT e FROM Etiquetas e WHERE e.nombre=?1")
	public Etiquetas findEtiquetabyNombre(String nombre);
}
