package airsoftspain.proyect.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsoftspain.proyect.entities.Rol;
import airsoftspain.proyect.repositories.RolRepository;

//Indicamos que es un servicio
@Service
public class RolDaoImpl implements RolDao {

	// Importamos las querys de repositorio de rol
	@Autowired
	RolRepository Rrepo;

	@Override
	public Rol verElRol(int idRol) {
		return Rrepo.findById(idRol).orElse(null);
	}

	// Método para buscar los usuarios por "nombre"
	@Override
	public Rol VerRolPorNombre(String nombre) {
		return Rrepo.encontrarRolXNombre(nombre);
	}

	//Métodos del CRUD
	// Método para buscar todos los roles (usamos el método existente ".findAll")
	@Override
	public List<Rol> filtrarRoles() {
		return Rrepo.findAll();
	}

	//Método para dar de alta a un rol
	@Override
	public Rol guardarRol(Rol rol) {
		return Rrepo.save(rol);

	}

	// Método para modificar un rol
	@Override
	public Rol modificarRol(Rol rol) {
		return Rrepo.save(rol);
	}

	// Método para eliminar un rol
	@Override
	public void eliminarRol(int id) {
		Rrepo.deleteById(id);
	}

}
