package airsoftspain.proyect.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsoftspain.proyect.entities.Usuario;
import airsoftspain.proyect.repositories.UsuarioRepository;

@Service
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	UsuarioRepository Urepo;
	

	@Override
	public List<Usuario> verLosUsuarios() {
		return Urepo.findAll();
	}

	@Override
	public Usuario buscarPorDNI(String dni) {
		return Urepo.encontrarUsuarioXId(dni);
	}

	@Override
	public List<Usuario> buscarPorCP(int CPostal) {
		return Urepo.encontrarUsuarioXCP(CPostal);
	}

	@Override
	public Usuario buscarPorAdress(String direccion) {
		return Urepo.encontrarUsuarioXAdress(direccion);
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		return Urepo.encontrarUsuarioXEmail(email);
	}

	@Override
	public Usuario buscarPorTlf(int telefono) {
		return Urepo.encontrarUsuarioTlf(telefono);
	}

	@Override
	public List<Usuario> buscarPorRol(int idRol) {
		return Urepo.encontrarUsuarioXIdRol(idRol);
	}

	@Override
	public Usuario buscarXId(int id) {
		return Urepo.encontrarUsuarioXId(id);
	}


	@Override
	public  boolean registro (Usuario usuario) {
		Urepo.save(usuario);
		return true;
	
		
	}

	@Override
	public Usuario guardarUser(Usuario usuario) {
 return Urepo.save(usuario);
	}
}
	

