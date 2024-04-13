package airsoftspain.proyect.entities;

import java.sql.Date;
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

@Table(name = "pedidos")
public class Pedido {

	// Indicamos que es la Primary Key
	@Id
	// Indicamos que es un autoincrement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Nombre distinto al de la columna en la bbdd
	@Column(name = "id_pedido")
	public int idPed;
	@Column(name = "id_user")
	public int idUser;
	@Column(name = "precio_total")
	public double total;
	@Column(name = "fecha")
	public Date fechaped;

	// Constructores
	public Pedido() {
		super();
	}

	public Pedido(int idPed, int idUser, double total, Date fechaped) {
		super();
		this.idPed = idPed;
		this.idUser = idUser;
		this.total = total;
		this.fechaped = fechaped;
	}

	// Getters and setters
	public int getIdPed() {
		return idPed;
	}

	public void setIdPed(int idPed) {
		this.idPed = idPed;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getFechaped() {
		return fechaped;
	}

	public void setFechaped(Date fechaped) {
		this.fechaped = fechaped;
	}

	// Hashcode y equals con la PK
	@Override
	public int hashCode() {
		return Objects.hash(idPed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return idPed == other.idPed;
	}

}
