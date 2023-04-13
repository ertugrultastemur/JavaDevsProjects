package kodlamaIO.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaIO.rentACar.entities.concretes.Car;

public interface ICarRepository extends JpaRepository<Car, Integer>{
	boolean existsByPlate(String plate);

}
