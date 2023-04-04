package kodlamaIO.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaIO.rentACar.business.abstracts.IBrandService;
import kodlamaIO.rentACar.business.concretes.BrandManager;
import kodlamaIO.rentACar.dataAccess.concretes.InMemoryBrandRepository;
import kodlamaIO.rentACar.entities.concretes.Brand;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
	IBrandService brandService;
	@Autowired
	public BrandsController(IBrandService brandService) {
		super();
		this.brandService = brandService;
	}
	@GetMapping("/getall")
	public List<Brand> getAll(){
		BrandManager brandManager = new BrandManager(new InMemoryBrandRepository());
		brandManager.getAll();
		return brandService.getAll();
	}
	

}