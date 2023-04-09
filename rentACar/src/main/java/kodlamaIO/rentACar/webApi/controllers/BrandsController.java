package kodlamaIO.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaIO.rentACar.business.abstracts.IBrandService;
import kodlamaIO.rentACar.business.requests.CreateBrandRequest;
import kodlamaIO.rentACar.business.responses.GetAllBrandsResponse;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
	IBrandService brandService;
	@Autowired
	public BrandsController(IBrandService brandService) {

		this.brandService = brandService;
	}
	@GetMapping()
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	}
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(CreateBrandRequest createBrandRequest) {
		this.brandService.delete(createBrandRequest);
	}
	

}
