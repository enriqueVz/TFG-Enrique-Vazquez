package airsoftspain.proyect.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//Identificamos la clase como una entidad en la BBDD

@Entity
//Anotación para indicar que el nombre de la tabla no coincide con la columna de la tabla en BBDD

@Table(name = "etiquetas")
public class Etiqueta {
	// Indicamos que es la Primary Key
	@Id
	// Indicamos que el campo es Autoincrement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Anotación para indicar que el nombre de la variable no coincide con el campo
	// de la tabla en BBDD
	@Column(name = "id_etiqueta")
	public int id;

	public String nombre;

	// Constructor vacío

	public Etiqueta() {
		super();
	}

	// Constructor con parámetros

	public Etiqueta(int id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;

	}

	// Getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		Etiqueta other = (Etiqueta) obj;
		return id == other.id;
	}

}