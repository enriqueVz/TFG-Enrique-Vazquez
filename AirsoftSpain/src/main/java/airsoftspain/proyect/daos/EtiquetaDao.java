package airsoftspain.proyect.daos;

import java.util.List;

import airsoftspain.proyect.entities.Etiqueta;

public interface EtiquetaDao {

	// Buscar etiqueta por "ID"
	public Etiqueta findPorId(int id);

	// Buscar etiqueta por "nombre"
	public Etiqueta findPorNombre(String nombre);

	// Métodos del CRUD
	public List<Etiqueta> listarLasEtiquetas();

	public Etiqueta guardarEtiqueta(Etiqueta etiqueta);

	public Etiqueta modificarEtiqueta(Etiqueta etiqueta);

	public void eliminarEtiqueta(int id);

}
