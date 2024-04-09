package airsoftspain.proyect.daos;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsoftspain.proyect.entities.Rol;
import airsoftspain.proyect.repositories.RolRepository;

@Service
public class RolDaoImpl implements RolDao{

	@Autowired 
	RolRepository Rrepo;

	@Override
	public Rol verElRol(int idRol) {
		return Rrepo.findById(idRol).orElse(null);
	}

	@Override
	public Rol VerRolPorNombre(String nombre) {
		return Rrepo.encontrarRolXNombre(nombre);
	}

	
//CRUD
	
@Override
	
	public List<Rol> filtrarRoles() {
		return Rrepo.findAll();
	}

	@Override
	public Rol guardarRol(Rol rol) {
		return Rrepo.save(rol);
		
	}

	@Override
	public Rol modificarRol(Rol rol) {
		return Rrepo.save(rol);
	}

	@Override
	public void eliminarRol(int id) {
		Rrepo.deleteById(id);
	}


}
