package kodlamaIO.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaIO.rentACar.business.abstracts.IBrandService;
import kodlamaIO.rentACar.business.requests.CreateBrandRequest;
import kodlamaIO.rentACar.business.responses.GetAllBrandsResponse;
import kodlamaIO.rentACar.core.utilities.mappers.IModelMapperService;
import kodlamaIO.rentACar.dataAccess.abstracts.IBrandRepository;
import kodlamaIO.rentACar.entities.concretes.Brand;

@Service
public class BrandManager implements IBrandService{

	private IBrandRepository brandRepository;
	private IModelMapperService modelMapperService;
	
	
	@Autowired
	public BrandManager(IBrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}


	@Override
	public List<GetAllBrandsResponse> getAll() {
		
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand->this.modelMapperService
						.forResponse().map(brand,GetAllBrandsResponse.class)).toList();
		return brandsResponse;
	}


	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandRepository.save(brand);
	} 


	@Override
	public void delete(CreateBrandRequest createBrandRequest) {
		List<Brand> brands = brandRepository.findAll();
		Brand brand = new Brand();
		for (Brand brand1 : brands) {
			brand=brand1;
			brand.setName(createBrandRequest.getName());
			if(brand1.getName() == brand.getName()) {
				
				this.brandRepository.delete(brand1);
				System.out.println("sasasassaassa");
			}
			System.out.println("xczcxzx"+brand1);
		}
		
		
	}


}
