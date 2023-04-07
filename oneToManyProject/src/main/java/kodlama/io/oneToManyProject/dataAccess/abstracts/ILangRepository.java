package kodlama.io.oneToManyProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.oneToManyProject.entities.concretes.Lang;

public interface ILangRepository extends JpaRepository<Lang, Integer>{

}
