package airsoftspain.proyect.daos;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsoftspain.proyect.entities.rol;
import airsoftspain.proyect.repositories.RolRepository;

@Service
public class RolDaoImpl implements rolDao{

	@Autowired 
	RolRepository Rrepo;
	@Override
	
	public List<rol> filtrarRoles() {
		return Rrepo.findAll();
	}

	@Override
	public rol verElRol(int idRol) {
		return Rrepo.findById(idRol).orElse(null);
	}


}
