package kodlamaIO.rentACar.business.abstracts;

import java.util.List;

import kodlamaIO.rentACar.business.requests.CreateCarRequest;
import kodlamaIO.rentACar.business.responses.GetAllCarsResponse;

public interface ICarService {

	List<GetAllCarsResponse> getAll();
	
	void add(CreateCarRequest createCarRequest);
}
