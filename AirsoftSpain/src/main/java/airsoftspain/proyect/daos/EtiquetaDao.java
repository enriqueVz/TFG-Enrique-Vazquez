package airsoftspain.proyect.daos;

import java.util.List;

import airsoftspain.proyect.entities.Etiqueta;

public interface EtiquetaDao {
	List<Etiqueta> listarLasEtiquetas();
	Etiqueta findPorId(int id);
	Etiqueta findPorNombre(String nombre);
	
}
