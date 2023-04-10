package kodlamaIO.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlamaIO.rentACar.core.utilities.exceptions.BusinessException;
import kodlamaIO.rentACar.dataAccess.abstracts.IBrandRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandBusinessRules {

	private IBrandRepository brandRepository;
	
	public void checkIfBrandNameExists(String name) {
		if(this.brandRepository.existsByName(name)) {
			throw new BusinessException("Brand name already exists.");
		}
	}
	
}
