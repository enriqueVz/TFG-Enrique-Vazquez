package airsoftspain.proyect.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsoftspain.proyect.entities.Etiqueta;
import airsoftspain.proyect.repositories.EtiquetaRepository;

//Indicamos que es un servicio
@Service
public class EtiquetaDaoImpl implements EtiquetaDao {

	// Importamos las querys de repositorio de usuario
	@Autowired
	EtiquetaRepository Erepo;

	// Método para buscar las etiquetas por "id"
	@Override
	public Etiqueta findPorId(int id) {
		return Erepo.findEtiquetabyID(id);
	}

	// Método para buscar las etiquetas por "id"
	@Override
	public Etiqueta findPorNombre(String nombre) {
		return Erepo.findEtiquetabyNombre(nombre);

	}

	// Métodos del CRUD
	// Método para buscar todos los usuarios (usamos el método existente ".findAll")
	@Override
	public List<Etiqueta> listarLasEtiquetas() {
		return Erepo.findAll();
	}

	// Método para dar de alta a una etiqueta
	@Override
	public Etiqueta guardarEtiqueta(Etiqueta etiqueta) {
		return Erepo.save(etiqueta);
	}

	// Método para modificar una etiqueta
	@Override
	public Etiqueta modificarEtiqueta(Etiqueta etiqueta) {
		return Erepo.save(etiqueta);
	}

	// Método para eliminar una etiqueta
	@Override
	public void eliminarEtiqueta(int id) {
		Erepo.deleteById(id);
	}
}
