package kodlamaIO.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.stereotype.Repository;

import kodlamaIO.rentACar.entities.concretes.Brand;


public interface IBrandRepository {
	List<Brand> getAll();
}