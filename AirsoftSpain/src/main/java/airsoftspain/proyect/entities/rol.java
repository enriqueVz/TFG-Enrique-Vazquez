package airsoftspain.proyect.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Identificamos la clase como una entidad en la BBDD
@Entity
public class Rol {
	// Indicamos que es la Primary Key
	@Id
	// Anotación para indicar que el nombre de la variable no coincide con el campo
	// de la tabla en BBDD
	@Column(name = "id_rol")
	// Indicamos que el campo es Autoincrement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String nombre;
	public String descripcion;

	// Constructor vacío
	public Rol() {
		super();
	}

	// Constructor con parámetros
	public Rol(int id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	// Getters and setters
	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// Equals and hashcode con la PK

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		return id == other.id;
	}

}
