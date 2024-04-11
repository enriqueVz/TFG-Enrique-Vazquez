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

@Table(name = "productos")
public class Producto {
	// Indicamos que es la Primary Key
	@Id
	// Anotación para indicar que el nombre de la variable no coincide con el campo
	// de la tabla en BBDD
	@Column(name = "id_producto")
	// Indicamos que el campo es Autoincrement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	// Anotación para indicar que el nombre de la variable no coincide con el campo

	@Column(name = "nombre_producto")
	public String nombre;
	public String descripcion;
	public int etiquetas;
	public double precio;
	public int stock;
	// Anotación para indicar que el nombre de la variable no coincide con el campo

	@Column(name = "tipo_producto_id")
	public int tipoProd;
	public String material;
	public String fabricante;
	public String mecanismo;

	// Constructor vacío

	public Producto() {
		super();
	}

	// Constructor con parámetros

	public Producto(int id, String nombre, String descripcion, int etiquetas, double precio, int stock, int tipoProd,
			String material, String fabricante, String mecanismo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.etiquetas = etiquetas;
		this.precio = precio;
		this.stock = stock;
		this.tipoProd = tipoProd;
		this.material = material;
		this.fabricante = fabricante;
		this.mecanismo = mecanismo;
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

	public int getTipoProd() {
		return tipoProd;
	}

	public void setTipoProd(int tipoProd) {
		this.tipoProd = tipoProd;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getMecanismo() {
		return mecanismo;
	}

	public void setMecanismo(String mecanismo) {
		this.mecanismo = mecanismo;
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
		Producto other = (Producto) obj;
		return id == other.id;
	}

}
