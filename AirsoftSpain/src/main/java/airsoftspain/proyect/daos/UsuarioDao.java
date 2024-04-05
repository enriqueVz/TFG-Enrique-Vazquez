package airsoftspain.proyect.daos;

import java.util.List;

import airsoftspain.proyect.entities.Usuario;

public interface UsuarioDao {

	List<Usuario> verLosUsuarios();
	Usuario buscarPorId(int dni);
	List<Usuario> buscarPorCP(int CPostal);
	Usuario buscarPorAdress(int direccion);
	Usuario buscarPorEmail(String email);
	Usuario buscarPorTlf(int telefono);
	List<Usuario> buscarPorRol(int idRol);
	
}
