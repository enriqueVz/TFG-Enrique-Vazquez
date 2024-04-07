package airsoftspain.proyect.entities;


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
@Table(name="pedidos")
public class Pedidos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idPed;
	public int idUser;
	public int idProds;
	
	


}
