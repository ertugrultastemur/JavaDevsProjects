package kodlamaIO.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaIO.rentACar.business.abstracts.IModelService;
import kodlamaIO.rentACar.business.requests.CreateModelRequest;
import kodlamaIO.rentACar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
	private IModelService modelService;
	
	@GetMapping
	public List<GetAllModelsResponse> getAll(){
		return modelService.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() CreateModelRequest createModelRequest) {
		this.modelService.add(createModelRequest);
	}
}
