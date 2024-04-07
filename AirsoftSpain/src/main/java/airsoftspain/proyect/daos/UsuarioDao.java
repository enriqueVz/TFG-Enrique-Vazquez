package airsoftspain.proyect.daos;

import java.util.List;

import airsoftspain.proyect.entities.Usuario;

public interface UsuarioDao {

	 public List<Usuario> verLosUsuarios();
	Usuario buscarPorDNI(String dni);
	List<Usuario> buscarPorCP(int CPostal);
	Usuario buscarPorAdress(String direccion);
	Usuario buscarPorEmail(String email);
	Usuario buscarPorTlf(int telefono);
	List<Usuario> buscarPorRol(int idRol);
	Usuario buscarXId(int id);
	boolean registro(Usuario user);
	
	
	public Usuario guardarUser(Usuario usuario);
	
}
