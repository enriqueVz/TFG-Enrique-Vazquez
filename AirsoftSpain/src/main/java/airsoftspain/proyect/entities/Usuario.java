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
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@Column(name="id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	@Column(name="DNI")
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
	
	
	
	public Usuario() {
		super();
	}



	public Usuario(int id, String dni, String nombre, String apellidos, int cPostal, String direccion, int idRol,
			String email, int telefono, String contraseña) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		CPostal = cPostal;
		this.direccion = direccion;
		this.idRol = idRol;
		this.email = email;
		this.telefono = telefono;
		this.contraseña = contraseña;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public int getCPostal() {
		return CPostal;
	}



	public void setCPostal(int cPostal) {
		CPostal = cPostal;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public int getIdRol() {
		return idRol;
	}



	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getTelefono() {
		return telefono;
	}



	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}



	public String getContraseña() {
		return contraseña;
	}



	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}



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
		Usuario other = (Usuario) obj;
		return id == other.id;
	}



	@Override
	public String toString() {
		return "Usuario [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", CPostal="
				+ CPostal + ", direccion=" + direccion + ", idRol=" + idRol + ", email=" + email + ", telefono="
				+ telefono + ", contraseña=" + contraseña + "]";
	}
	
	
	}
	
	
	