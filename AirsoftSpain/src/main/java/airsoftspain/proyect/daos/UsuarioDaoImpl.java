package airsoftspain.proyect.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsoftspain.proyect.entities.Usuario;
import airsoftspain.proyect.repositories.UsuarioRepository;

//Indicamos que es un servicio
@Service
public class UsuarioDaoImpl implements UsuarioDao {

	// Importamos las querys de repositorio de usuario
	@Autowired
	UsuarioRepository Urepo;

	// Método para buscar los usuarios por "id"
		@Override
		public Usuario buscarXId(int id) {
			return Urepo.encontrarUsuarioXId(id);
		}
		
	// Método para buscar los usuarios por "ID del rol"
	@Override
	public List<Usuario> buscarPorRol(int idRol) {
		return Urepo.encontrarUsuarioXIdRol(idRol);
	}

	// Método para buscar los usuarios por "DNI"
	@Override
	public Usuario buscarPorDNI(String dni) {
		return Urepo.encontrarUsuarioXId(dni);
	}

	// Método para buscar los usuarios por "código postal"
	@Override
	public List<Usuario> buscarPorCP(int CPostal) {
		return Urepo.encontrarUsuarioXCP(CPostal);
	}

	// Método para buscar los usuarios por "dirección"
	@Override
	public Usuario buscarPorAdress(String direccion) {
		return Urepo.encontrarUsuarioXAdress(direccion);
	}

	// Método para buscar los usuarios por "email"
	@Override
	public Usuario buscarPorEmail(String email) {
		return Urepo.encontrarUsuarioXEmail(email);
	}

	// Método para buscar los usuarios por "teléfono"
	@Override
	public Usuario buscarPorTlf(int telefono) {
		return Urepo.encontrarUsuarioTlf(telefono);
	}

	// Métodos del CRUD
	// Método para buscar todos los usuarios (usamos el método existente ".findAll")
	@Override
	public List<Usuario> verLosUsuarios() {
		return Urepo.findAll();
	}

	// Método para dar de alta a un usuario
	@Override
	public Usuario guardarUser(Usuario usuario) {
		return Urepo.save(usuario);
	}

	// Método para modificar un usuario
	@Override
	public Usuario modificarUser(Usuario usuario) {
		return Urepo.save(usuario);
	}

	// Método para eliminar un usuario
	@Override
	public void eliminarUser(int id) {
		Urepo.deleteById(id);
	}
}
