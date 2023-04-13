package kodlamaIO.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlamaIO.rentACar.business.abstracts.ICarService;
import kodlamaIO.rentACar.business.requests.CreateCarRequest;
import kodlamaIO.rentACar.business.responses.GetAllCarsResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarsController {

	private ICarService carService;
	
	@GetMapping()
	public List<GetAllCarsResponse> getAll(){
		return carService.getAll();
		}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateCarRequest createCarRequest) {
		this.carService.add(createCarRequest);
	}
	
}
