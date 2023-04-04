package kodlamaIO.rentACar.business.abstracts;

import java.util.List;

import kodlamaIO.rentACar.entities.concretes.Brand;

public interface IBrandService {
	List<Brand> getAll();
}
