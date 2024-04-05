package airsoftspain.proyect.daos;

import java.util.List;

import airsoftspain.proyect.entities.Etiquetas;

public interface EtiquetasDao {
	List<Etiquetas> listarLasEtiquetas();
	Etiquetas findPorId(int id);
	Etiquetas findPorNombre(String nombre);
	
}
