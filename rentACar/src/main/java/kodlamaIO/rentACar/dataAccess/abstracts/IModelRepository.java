package kodlamaIO.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaIO.rentACar.entities.concretes.Model;

public interface IModelRepository extends JpaRepository<Model, Integer> {
	
}
