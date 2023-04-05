package kodlamaIO.rentACar.business.abstracts;

import java.util.List;

import kodlamaIO.rentACar.business.requests.CreateBrandRequest;
import kodlamaIO.rentACar.business.responses.GetAllBrandsResponse;


public interface IBrandService {
	List<GetAllBrandsResponse> getAll();
	
	void add(CreateBrandRequest createBrandRequest);
	
	void delete(CreateBrandRequest createBrandRequest);
	
}
