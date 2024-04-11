package airsoftspain.proyect.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import airsoftspain.proyect.entities.Usuario;

//Indicamos que es un repositorio
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	// Query para filtrar usuarios por el campo "id"
	@Query("SELECT u FROM Usuario u WHERE u.id=?1")
	public Usuario encontrarUsuarioXId(int id);

	// Query para filtrar usuarios por el campo "dni"
	@Query("SELECT u FROM Usuario u WHERE u.dni=?1")
	public Usuario encontrarUsuarioXId(String dni);

	// Query para filtrar usuarios por el campo "nombre"
	@Query("SELECT u FROM Usuario u WHERE u.nombre=?1")
	public List<Usuario> encontrarUsuarioXNombre(String nombre);

	// Query para filtrar usuarios por el campo "código postal"
	@Query("SELECT u FROM Usuario u WHERE u.CPostal=?1")
	public List<Usuario> encontrarUsuarioXCP(int CPostal);

	// Query para filtrar usuarios por el campo "dirección"
	@Query("SELECT u FROM Usuario u WHERE u.direccion=?1")
	public Usuario encontrarUsuarioXAdress(String direccion);

	// Query para filtrar usuarios por el campo "teléfono"
	@Query("SELECT u FROM Usuario u WHERE u.telefono=?1")
	public Usuario encontrarUsuarioTlf(int telefono);

	// Query para filtrar usuarios por el campo "email"
	@Query("SELECT u FROM Usuario u WHERE u.email=?1")
	public Usuario encontrarUsuarioXEmail(String email);

	// Query para filtrar usuarios por el campo "ID del rol"
	@Query("SELECT u FROM Usuario u WHERE u.idRol=?1")
	public List<Usuario> encontrarUsuarioXIdRol(int idRol);

}