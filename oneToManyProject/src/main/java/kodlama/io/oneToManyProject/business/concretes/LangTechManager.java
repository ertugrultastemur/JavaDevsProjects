package kodlama.io.oneToManyProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import kodlama.io.oneToManyProject.business.abstracts.ILangTechService;
import kodlama.io.oneToManyProject.business.requests.CreateLangTechRequest;
import kodlama.io.oneToManyProject.business.responses.GetAllLangTechsResponse;
import kodlama.io.oneToManyProject.dataAccess.abstracts.ILangTechRepository;
import kodlama.io.oneToManyProject.entities.concretes.LangTech;

@Service
public class LangTechManager implements ILangTechService{
	
	ILangTechRepository langTechRepository;
	
	@Autowired
	public LangTechManager(ILangTechRepository langTechRepository) {
		
		this.langTechRepository = langTechRepository;
	}

	@Override
	public List<GetAllLangTechsResponse> getAll() {
		List<GetAllLangTechsResponse> langTechsResponse = new ArrayList<GetAllLangTechsResponse>();
		List<LangTech> langTechs= langTechRepository.findAll();
		for (LangTech techItem : langTechs) {
			GetAllLangTechsResponse langResponse= new GetAllLangTechsResponse();
			langResponse.setId(techItem.getId());
			langResponse.setName(techItem.getName());
			langTechsResponse.add(langResponse);
		}
		return langTechsResponse;
	}

	@Override
	public GetAllLangTechsResponse getById(int id) {
		List<LangTech> langTechs= langTechRepository.findAll();
		GetAllLangTechsResponse langTech = new GetAllLangTechsResponse();
		for (LangTech langItem : langTechs) {
			if(id==langItem.getId()) ;
			langTech.setName(langItem.getName());
		}
		return langTech;
	}

	@Override
	public void add(CreateLangTechRequest langTechRequest) {
		LangTech langTech = new LangTech();
		langTech.setName(langTechRequest.getName());
		langTechRepository.save(langTech);
		
	}

	@Override
	public void update(CreateLangTechRequest langTechRequest, String name) {
		List<LangTech> langItem=langTechRepository.findAll();
		for (LangTech langTech : langItem) {
			if(langTech.getName()==langTechRequest.getName()) {
				langTech.setName(name);
				break;
			}
		}
	}

	@Override
	public void delete(CreateLangTechRequest langTechRequest) {
		List<LangTech> langTechs = langTechRepository.findAll();
		for (LangTech langItem : langTechs) {
			if(langTechRequest.getName() == langItem.getName()) {
				langTechRepository.delete(langItem);
				break;
			}
		}
		
	}
	

	

	
}
