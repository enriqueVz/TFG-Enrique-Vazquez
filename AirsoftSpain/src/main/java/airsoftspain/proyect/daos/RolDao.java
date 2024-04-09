package airsoftspain.proyect.daos;

import java.util.List;


import airsoftspain.proyect.entities.Rol;

public interface RolDao {

	public Rol verElRol(int idRol);
	public Rol VerRolPorNombre(String nombre);
	
	//CRUD	 
	public List<Rol>filtrarRoles();

	public Rol guardarRol(Rol rol);
	
	public Rol modificarRol(Rol rol);
	
	public void eliminarRol (int id);
	
}
