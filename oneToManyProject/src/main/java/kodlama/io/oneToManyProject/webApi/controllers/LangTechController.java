package kodlama.io.oneToManyProject.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.SqlResultSetMapping;
import kodlama.io.oneToManyProject.business.abstracts.ILangTechService;
import kodlama.io.oneToManyProject.business.requests.CreateLangTechRequest;
import kodlama.io.oneToManyProject.business.responses.GetAllLangTechsResponse;

@RestController
@RequestMapping(name="/api/langtechs")
public class LangTechController {

	ILangTechService langTechService;

	@Autowired
	public LangTechController(ILangTechService langTechService) {
		this.langTechService = langTechService;
	}
	
	@GetMapping(name="/getall")
	List<GetAllLangTechsResponse> getAll(){
		return langTechService.getAll();
	}
	
	
	@GetMapping(name="/getbyid")
	GetAllLangTechsResponse getById(int id) {
		return langTechService.getById(id);
	}
	
	@PostMapping(name="/add")
	void add(CreateLangTechRequest langTechRequest) {
		langTechService.add(langTechRequest);
	}
	
	@PostMapping(name="/update")
	void update(CreateLangTechRequest langTechRequest, String name) {
		langTechService.update(langTechRequest, name);
	}
	
	 
	@DeleteMapping(name="/delete")
	void delete(CreateLangTechRequest langTechRequest) {
		langTechService.delete(langTechRequest);
	}
	
	
}
