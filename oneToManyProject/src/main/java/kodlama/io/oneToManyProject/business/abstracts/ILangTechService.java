package kodlama.io.oneToManyProject.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.oneToManyProject.business.requests.CreateLangTechRequest;
import kodlama.io.oneToManyProject.business.responses.GetAllLangTechsResponse;

public interface ILangTechService {
	
	List<GetAllLangTechsResponse> getAll();
	
	GetAllLangTechsResponse getById(int id);
	
	void add(CreateLangTechRequest langTechRequest);
	
	void update(CreateLangTechRequest langTechRequest,String name);
	
	void delete(CreateLangTechRequest langTechRequest);
}
