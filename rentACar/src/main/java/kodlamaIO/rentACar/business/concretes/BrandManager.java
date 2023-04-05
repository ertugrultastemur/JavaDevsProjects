package kodlamaIO.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaIO.rentACar.business.abstracts.IBrandService;
import kodlamaIO.rentACar.business.requests.CreateBrandRequest;
import kodlamaIO.rentACar.business.responses.GetAllBrandsResponse;
import kodlamaIO.rentACar.dataAccess.abstracts.IBrandRepository;
import kodlamaIO.rentACar.entities.concretes.Brand;

@Service
public class BrandManager implements IBrandService{

	IBrandRepository brandRepository;
	
	
	@Autowired
	public BrandManager(IBrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}


	@Override
	public List<GetAllBrandsResponse> getAll() {
		
		List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
		List<Brand> brands = brandRepository.findAll();
		for (Brand brand : brands) {
			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
			responseItem.setId(brand.getId());
			responseItem.setName(brand.getName());
			brandsResponse.add(responseItem);
		}
		return brandsResponse;
	}


	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		Brand brand = new Brand();
		brand.setName(createBrandRequest.getName());
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
