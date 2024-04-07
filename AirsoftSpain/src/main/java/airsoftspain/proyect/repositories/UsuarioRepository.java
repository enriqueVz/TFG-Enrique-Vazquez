package airsoftspain.proyect.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import airsoftspain.proyect.entities.Usuario;

@Repository
//MIRAR SI ES VARCHAR EN VE DE STRING
public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{
	
	@Query("SELECT u FROM Usuario u")
	public Usuario encontrarUsuarios();
	
	@Query("SELECT u FROM Usuario u WHERE u.dni=?1")
	public Usuario encontrarUsuarioXId(String dni);

	@Query("SELECT u FROM Usuario u WHERE u.nombre=?1")
	public List<Usuario> encontrarUsuarioXNombre(String nombre);
	
	@Query("SELECT u FROM Usuario u WHERE u.CPostal=?1")
	public List<Usuario> encontrarUsuarioXCP(int CPostal);
	
	@Query("SELECT u FROM Usuario u WHERE u.direccion=?1")
	public Usuario encontrarUsuarioXAdress(String direccion);
	
	@Query("SELECT u FROM Usuario u WHERE u.telefono=?1")
	public Usuario encontrarUsuarioTlf(int telefono);
	
	@Query("SELECT u FROM Usuario u WHERE u.email=?1")
	public Usuario encontrarUsuarioXEmail(String email);
	
	@Query("SELECT u FROM Usuario u WHERE u.idRol=?1")
	public List<Usuario> encontrarUsuarioXIdRol (int idRol);
	
	@Query("SELECT u FROM Usuario u WHERE u.id=?1")
	public Usuario encontrarUsuarioXId (int id);
	
}