package kodlamaIO.rentACar.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaIO.rentACar.business.abstracts.ICarService;
import kodlamaIO.rentACar.business.requests.CreateCarRequest;
import kodlamaIO.rentACar.business.responses.GetAllCarsResponse;
import kodlamaIO.rentACar.business.rules.CarBusinessRules;
import kodlamaIO.rentACar.core.utilities.mappers.IModelMapperService;
import kodlamaIO.rentACar.dataAccess.abstracts.ICarRepository;
import kodlamaIO.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CarManager implements ICarService{

	private ICarRepository carRepository;
	private IModelMapperService modelMapperService;
	private CarBusinessRules carBusinessRules;

	@Override
	public List<GetAllCarsResponse> getAll() {
		List<Car> cars = carRepository.findAll();
		List<GetAllCarsResponse> carsResponse = cars.stream().map(car -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class)).toList();
		return carsResponse;
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {
		this.carBusinessRules.checkIfCarPlateExist(createCarRequest.getPlate());
		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carRepository.save(car);
	}
	
	
}
