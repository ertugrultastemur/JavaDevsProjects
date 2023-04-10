package kodlamaIO.rentACar.business.responses;

import kodlamaIO.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelsResponse {
	
	private int id;
	private String name;
	private String BrandName;
}
