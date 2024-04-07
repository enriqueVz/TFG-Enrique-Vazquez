package airsoftspain.proyect.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsoftspain.proyect.entities.Etiquetas;
import airsoftspain.proyect.repositories.EtiquetasRepository;

@Service
public class EtiquetasDaoImpl implements EtiquetasDao {

	@Autowired
	EtiquetasRepository Erepo;
	
	@Override
	public List<Etiquetas> listarLasEtiquetas() {
	return Erepo.findAll();
	}

	@Override
	public Etiquetas findPorId(int id) {
		return Erepo.findEtiquetabyID(id);
	}

	@Override
	public Etiquetas findPorNombre(String nombre) {
		return Erepo.findEtiquetabyNombre(nombre);
		
	}

}
