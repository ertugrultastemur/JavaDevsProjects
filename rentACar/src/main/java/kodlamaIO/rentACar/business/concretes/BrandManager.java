package kodlamaIO.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaIO.rentACar.business.abstracts.IBrandService;
import kodlamaIO.rentACar.business.requests.CreateBrandRequest;
import kodlamaIO.rentACar.business.requests.UpdateBrandRequest;
import kodlamaIO.rentACar.business.responses.GetAllBrandsResponse;
import kodlamaIO.rentACar.business.responses.GetByIdBrandsResponse;
import kodlamaIO.rentACar.business.rules.BrandBusinessRules;
import kodlamaIO.rentACar.core.utilities.mappers.IModelMapperService;
import kodlamaIO.rentACar.dataAccess.abstracts.IBrandRepository;
import kodlamaIO.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements IBrandService{

	private IBrandRepository brandRepository;
	private IModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;
	

	@Override
	public List<GetAllBrandsResponse> getAll() {
		
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand->this.modelMapperService
						.forResponse().map(brand,GetAllBrandsResponse.class)).toList();
		return brandsResponse;
	}

	@Override
		public GetByIdBrandsResponse getById(int id) {
			Brand brand = this.brandRepository.findById(id).orElseThrow();
			GetByIdBrandsResponse brandResponse = this.modelMapperService.forResponse().map(brand, GetByIdBrandsResponse.class);
			return brandResponse;
		}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		
		this.brandRepository.save(brand);
	} 

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
	}
	
	@Override
	public void delete(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		this.brandRepository.delete(brand);
		
		
	}




	

}
