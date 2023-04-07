package kodlama.io.oneToManyProject.business.concretes;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.oneToManyProject.business.abstracts.ILangService;
import kodlama.io.oneToManyProject.business.requests.CreateLangRequest;
import kodlama.io.oneToManyProject.business.requests.CreateLangTechRequest;
import kodlama.io.oneToManyProject.business.responses.GetAllLangsResponse;
import kodlama.io.oneToManyProject.dataAccess.abstracts.ILangRepository;
import kodlama.io.oneToManyProject.dataAccess.abstracts.ILangTechRepository;
import kodlama.io.oneToManyProject.entities.concretes.Lang;
import kodlama.io.oneToManyProject.entities.concretes.LangTech;


@Service
public class LangManager implements ILangService{
	
	ILangRepository langRepository;
	
	
	@Autowired
	public LangManager(ILangRepository langRepository, ILangTechRepository langTechRepository) {

		this.langRepository = langRepository;
	}



	@Override
	public List<GetAllLangsResponse> getAll() {
		List<GetAllLangsResponse> langsResponse=new ArrayList<GetAllLangsResponse>();
		List<Lang> langs = langRepository.findAll();
		for(Lang lang : langs){
			GetAllLangsResponse langResponse = new GetAllLangsResponse();
			langResponse.setId(lang.getId());
			langResponse.setName(lang.getName());
			langsResponse.add(langResponse);
		}
		return langsResponse;
	}
	

	@Override
	public void add(CreateLangRequest langRequest) {
		Lang lang = new Lang();
		lang.setName(langRequest.getName());
		langRepository.save(lang);
		
	}



	@Override
	public GetAllLangsResponse getById(int id) {
		GetAllLangsResponse langResponse = new GetAllLangsResponse();
		List<Lang> langs = langRepository.findAll();
		for (Lang lang : langs) {
			if(lang.getId()==id) {
				langResponse.setName(lang.getName());
				break;
			}
		}
		return langResponse;
	}



	@Override
	public void update(CreateLangRequest langRequest, String name) {
		List<Lang> langs = langRepository.findAll();
		for (Lang lang : langs) {
			if(langRequest.getName()==lang.getName()) lang.setName(name);
			break;
		}
	}



	@Override
	public void delete(int id) {
		Lang lang = new Lang();
		List<Lang> langs = langRepository.findAll();
		for (Lang lang1 : langs) {
			if(id==lang1.getId()) {
				lang=lang1;
				langRepository.deleteById(lang1.getId());
				System.out.println("sa");
				break;
			}
		}
	}
	

}
