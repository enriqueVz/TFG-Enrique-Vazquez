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
@Table(name="productos")
public class Producto {
//MIRAR LOS @ DE ARRIBA Q NO FURULAN
	//LAS VARIABLES NO PUEDEN DECLARARSE CON "_-"
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_producto")
	public int id;
	@Column(name="nombre_producto")
	public String nombre;
	public String descripcion;
	public int etiquetas;
	public double precio;
	public int stock;
	@Column(name="tipo_producto_id")
	public int tipoProd;
	
	
	public Producto() {
		super();
	}


	public Producto(int id, String nombre, String descripcion, int etiquetas, double precio, int stock,
			int tipoProd) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.etiquetas = etiquetas;
		this.precio = precio;
		this.stock = stock;
		this.tipoProd = tipoProd;
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


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getEtiquetas() {
		return etiquetas;
	}


	public void setEtiquetas(int etiquetas) {
		this.etiquetas = etiquetas;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int gettipoProd() {
		return tipoProd;
	}


	public void settipoProd(int tipoProd) {
		this.tipoProd = tipoProd;
	}


	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre_p=" + nombre + ", descripcion=" + descripcion + ", etiquetas="
				+ etiquetas + ", precio=" + precio + ", stock=" + stock + ", tipoProd=" + tipoProd + "]";
	}


	
	//CON LA PK SOLO
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
		Producto other = (Producto) obj;
		return id == other.id;
	}
	
}



