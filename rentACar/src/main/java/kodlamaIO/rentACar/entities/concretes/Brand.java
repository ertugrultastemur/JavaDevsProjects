package kodlamaIO.rentACar.entities.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="brands")
public class Brand {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Model> models= new ArrayList<>();
	
	
	@Column(name="name")
	private String name;
	

}
