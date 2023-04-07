package kodlama.io.oneToManyProject.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.SqlResultSetMapping;
import kodlama.io.oneToManyProject.business.abstracts.ILangTechService;
import kodlama.io.oneToManyProject.business.requests.CreateLangTechRequest;
import kodlama.io.oneToManyProject.business.responses.GetAllLangTechsResponse;

@RestController
@RequestMapping(value="/api/langtechs")
public class LangTechController {

	ILangTechService langTechService;

	@Autowired
	public LangTechController(ILangTechService langTechService) {
		this.langTechService = langTechService;
	}
	
	@RequestMapping(value="/all")
	List<GetAllLangTechsResponse> getAll(){
		return langTechService.getAll();
	}
	
	
	@GetMapping(value="/{id}")
	GetAllLangTechsResponse getById(int id) {
		return langTechService.getById(id);
	}
	
	
	@PostMapping(value="/add")
	void add(CreateLangTechRequest langTechRequest) {
		langTechService.add(langTechRequest);
	}
	
	@PutMapping(value="/update")
	void update(CreateLangTechRequest langTechRequest,@RequestParam String name) {
		langTechService.update(langTechRequest, name);
	}
	
	 
	@DeleteMapping(value="/delete")
	void delete(@RequestParam CreateLangTechRequest langTechRequest) {
		langTechService.delete(langTechRequest);
	}
	
	
}
