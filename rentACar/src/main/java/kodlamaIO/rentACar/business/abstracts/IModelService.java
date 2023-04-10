package kodlamaIO.rentACar.business.abstracts;

import java.util.List;

import kodlamaIO.rentACar.business.requests.CreateModelRequest;
import kodlamaIO.rentACar.business.responses.GetAllModelsResponse;

public interface IModelService {
	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);
}
