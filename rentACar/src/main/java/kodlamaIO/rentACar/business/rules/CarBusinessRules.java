package kodlamaIO.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlamaIO.rentACar.core.utilities.exceptions.BusinessException;
import kodlamaIO.rentACar.dataAccess.abstracts.ICarRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CarBusinessRules {
	private ICarRepository carRepository;
	
	public void checkIfCarPlateExist(String plate) {
		if(carRepository.existsByPlate(plate)) {
			throw new BusinessException("State is already exists");
		}
	}
}
