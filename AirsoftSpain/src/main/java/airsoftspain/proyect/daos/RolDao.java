package airsoftspain.proyect.daos;

import java.util.List;


import airsoftspain.proyect.entities.Rol;

public interface RolDao {

	//Buscar roles por "id"
	public Rol verElRol(int id);
	
	//Buscar roles por "nombre"
	public Rol VerRolPorNombre(String nombre);
	
	//Métodos del CRUD	 
	public List<Rol>filtrarRoles();

	public Rol guardarRol(Rol rol);
	
	public Rol modificarRol(Rol rol);
	
	public void eliminarRol (int id);
	
}
