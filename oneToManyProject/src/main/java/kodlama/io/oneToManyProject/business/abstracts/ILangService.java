package kodlama.io.oneToManyProject.business.abstracts;

import java.util.List;

import kodlama.io.oneToManyProject.business.requests.CreateLangRequest;
import kodlama.io.oneToManyProject.business.responses.GetAllLangsResponse;
import kodlama.io.oneToManyProject.entities.concretes.Lang;

public interface ILangService {
	List<GetAllLangsResponse> getAll();
	GetAllLangsResponse getById(int id);
	void add(CreateLangRequest langRequest);
	void update(CreateLangRequest langRequest, String name);
	void delete(CreateLangRequest langRequest);
	
}
