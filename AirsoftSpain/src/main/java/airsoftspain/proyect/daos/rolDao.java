package airsoftspain.proyect.daos;

import java.util.List;

import airsoftspain.proyect.entities.rol;

public interface rolDao {

	List<rol>filtrarRoles();
	rol verElRol(int idRol);
	
}
