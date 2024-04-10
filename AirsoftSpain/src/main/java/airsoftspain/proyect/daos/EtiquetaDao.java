package airsoftspain.proyect.daos;

import java.util.List;

import airsoftspain.proyect.entities.Etiqueta;

public interface EtiquetaDao {
	
	public Etiqueta findPorId(int id);
	public Etiqueta findPorNombre(String nombre);
	
	
	//Crud
	public List<Etiqueta> listarLasEtiquetas();
	
	public Etiqueta guardarEtiqueta(Etiqueta etiqueta);
	
	public Etiqueta modificarEtiqueta(Etiqueta etiqueta);
	
	public void eliminarEtiqueta(int id);
	
	
	
}
