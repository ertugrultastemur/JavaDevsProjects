package kodlamaIO.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaIO.rentACar.business.responses.GetAllBrandsResponse;
import kodlamaIO.rentACar.entities.concretes.Brand;


public interface IBrandRepository extends JpaRepository<Brand, Integer>{
	
}
