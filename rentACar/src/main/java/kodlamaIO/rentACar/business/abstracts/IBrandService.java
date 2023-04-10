package kodlamaIO.rentACar.business.abstracts;

import java.util.List;

import kodlamaIO.rentACar.business.requests.CreateBrandRequest;
import kodlamaIO.rentACar.business.requests.UpdateBrandRequest;
import kodlamaIO.rentACar.business.responses.GetAllBrandsResponse;
import kodlamaIO.rentACar.business.responses.GetByIdBrandsResponse;


public interface IBrandService {
	List<GetAllBrandsResponse> getAll();
	
	GetByIdBrandsResponse getById(int id);
	
	void add(CreateBrandRequest createBrandRequest);
	
	void update(UpdateBrandRequest updateBrandRequest);
	
	void delete(int id);
	
}
