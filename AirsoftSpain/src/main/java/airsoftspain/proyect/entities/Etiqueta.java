package airsoftspain.proyect.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="etiquetas")
public class Etiqueta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_etiqueta")
	public int id;
	public String nombre;
	
	
	
	public Etiqueta() {
		super();
	}


	public Etiqueta(int id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		
	}


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


	@Override
	public String toString() {
		return "Etiqueta [id=" + id + ", nombre=" + nombre + "]";
	}

	//Hashcode con la PK
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