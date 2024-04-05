package airsoftspain.proyect.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import airsoftspain.proyect.entities.Usuario;
import airsoftspain.proyect.repositories.UsuarioRepository;

public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	UsuarioRepository Urepo;
	

	@Override
	public List<Usuario> verLosUsuarios() {
		return Urepo.findAll();
	}

	@Override
	public Usuario buscarPorId(int dni) {
		return Urepo.encontrarUsuarioXId(dni);
	}

	@Override
	public List<Usuario> buscarPorCP(int CPostal) {
		return Urepo.encontrarUsuarioXCP(CPostal);
	}

	@Override
	public List<Usuario> buscarPorAdress(int direccion) {
		return Urepo.encontrarUsuarioXAdress(direccion);
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		return Urepo.encontrarUsuarioXEmail(email);
	}

	@Override
	public Usuario buscarPorTlf(int telefono) {
		return ;
	}

	@Override
	public List<Usuario> buscarPorRol(int idRol) {
		return ;
	}

}
