package kodlamaIO.rentACar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaIO.rentACar.business.abstracts.IBrandService;
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
	public List<Brand> getAll() {
		
		
		return brandRepository.getAll();
	}

}