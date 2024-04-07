package airsoftspain.proyect.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import airsoftspain.proyect.entities.rol;

@Repository
public interface RolRepository extends JpaRepository <rol, Integer> {

	@Query("SELECT r from rol r WHERE r.idRol=?1")
	public rol encontrarRolXId(int idRol);
}
