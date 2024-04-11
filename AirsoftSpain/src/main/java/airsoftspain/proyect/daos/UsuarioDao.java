package airsoftspain.proyect.daos;

import java.util.List;

import airsoftspain.proyect.entities.Usuario;

public interface UsuarioDao {

	// Buscar usuario por "id"
	Usuario buscarXId(int id);

	// Buscar usuario por "dni"
	Usuario buscarPorDNI(String dni);

	// Buscar usuario por "Código postal"
	List<Usuario> buscarPorCP(int CPostal);

	// Buscar usuario por "dirección"
	Usuario buscarPorAdress(String direccion);

	// Buscar usuario por "email"
	Usuario buscarPorEmail(String email);

	// Buscar usuario por "teléfono"
	Usuario buscarPorTlf(int telefono);

	// Buscar usuario por "ID del rol"
	List<Usuario> buscarPorRol(int idRol);

	// Métodos del CRUD
	public List<Usuario> verLosUsuarios();

	public Usuario guardarUser(Usuario usuario);

	public Usuario modificarUser(Usuario usuario);

	public void eliminarUser(int id);

}
