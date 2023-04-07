package kodlama.io.oneToManyProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.oneToManyProject.entities.concretes.LangTech;

public interface ILangTechRepository extends JpaRepository<LangTech, Integer>{

}
