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
@Table(name="productos")
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String nombre_p;
	public String descripcion;
	public int etiquetas;
	public double precio;
	public int stock;
	public int tipo_prod;
}


