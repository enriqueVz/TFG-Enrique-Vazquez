package airsoftspain.proyect.entities;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//Identificamos la clase como una entidad en la BBDD

@Entity
//Anotación para indicar que el nombre de la tabla no coincide con la columna de la tabla en BBDD

@Table(name="pedidos")
public class Pedido {
	
	// Indicamos que es la Primary Key

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idPed;
	public int idUser;
	public int idProds;
	
	


}
