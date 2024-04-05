package airsoftspain.proyect.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="usuarios")
public class Usuario {
	
	@Column(name="DNI")
	@Id
	public String dni;
	public String nombre;
	public String apellidos;
	public int CPostal;
	public String direccion;
	@Column(name="id_rol")
	public int idRol;
	public String email;
	public int telefono;
	public String contraseña;
	

}
