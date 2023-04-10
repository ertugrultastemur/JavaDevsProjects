package kodlamaIO.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaIO.rentACar.entities.concretes.Brand;


public interface IBrandRepository extends JpaRepository<Brand, Integer>{
	boolean existsByName(String name);
}
