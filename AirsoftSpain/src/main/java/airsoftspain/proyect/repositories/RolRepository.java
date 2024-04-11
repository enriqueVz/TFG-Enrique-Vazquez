package airsoftspain.proyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import airsoftspain.proyect.entities.Rol;

//Indicamos que es un repositorio
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

	//Query para filtrar roles por el campo "id"
	@Query("SELECT r from Rol r WHERE r.id=?1")
	public Rol encontrarRolXId(int id);

	//Query para filtrar roles por el campo "nombre"
	@Query("SELECT r from Rol r WHERE r.nombre=?1")
	public Rol encontrarRolXNombre(String nombre);

}
