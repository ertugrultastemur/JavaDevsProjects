package kodlamaIO.rentACar.dataAccess.concretes;

import java.util.List;

import org.springframework.stereotype.Repository;

import kodlamaIO.rentACar.dataAccess.abstracts.IBrandRepository;
import kodlamaIO.rentACar.entities.concretes.Brand;

import java.util.ArrayList;

@Repository
public class InMemoryBrandRepository implements IBrandRepository{
	List<Brand> brands;
	
	public InMemoryBrandRepository() {
		brands = new ArrayList<Brand>();
		brands.add(new Brand(1,"BMW"));
		brands.add(new Brand(2,"Audi"));
		brands.add(new Brand(3,"Skoda"));
		brands.add(new Brand(4,"Mercedes"));
		brands.add(new Brand(5,"Honda"));
		brands.add(new Brand(6,"Ferrari"));
		brands.add(new Brand(7,"Ford"));
		

	}

	@Override
	public List<Brand> getAll() {
		return brands;
	}

}
