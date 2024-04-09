package airsoftspain.proyect.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsoftspain.proyect.entities.Etiqueta;
import airsoftspain.proyect.repositories.EtiquetaRepository;

@Service
public class EtiquetaDaoImpl implements EtiquetaDao {

	@Autowired
	EtiquetaRepository Erepo;
	
	@Override
	public List<Etiqueta> listarLasEtiquetas() {
	return Erepo.findAll();
	}

	@Override
	public Etiqueta findPorId(int id) {
		return Erepo.findEtiquetabyID(id);
	}

	@Override
	public Etiqueta findPorNombre(String nombre) {
		return Erepo.findEtiquetabyNombre(nombre);
		
	}

}
