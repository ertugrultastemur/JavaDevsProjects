package kodlamaIO.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlamaIO.rentACar.business.abstracts.IModelService;
import kodlamaIO.rentACar.business.requests.CreateModelRequest;
import kodlamaIO.rentACar.business.responses.GetAllModelsResponse;
import kodlamaIO.rentACar.core.utilities.mappers.IModelMapperService;
import kodlamaIO.rentACar.dataAccess.abstracts.IModelRepository;
import kodlamaIO.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements IModelService{
	
	private IModelRepository modelRepository;
	private IModelMapperService modelMapperService;
	
	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();
		List<GetAllModelsResponse> modelsResponse = models.stream()
				.map(model->this.modelMapperService.forResponse()
						.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());		
		return modelsResponse;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		this.modelRepository.save(model);
	}

}
