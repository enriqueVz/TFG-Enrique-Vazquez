package airsoftspain.proyect.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import airsoftspain.proyect.entities.Rol;

@Repository
public interface RolRepository extends JpaRepository <Rol, Integer> {

	@Query("SELECT r from Rol r WHERE r.idRol=?1")
	public Rol encontrarRolXId(int idRol);
	
	@Query("SELECT r from Rol r WHERE r.nombre=?1")
	public Rol encontrarRolXNombre(String nombre);
	
	
	
}
