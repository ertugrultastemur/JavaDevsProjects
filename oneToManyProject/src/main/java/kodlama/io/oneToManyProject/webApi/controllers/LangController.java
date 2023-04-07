package kodlama.io.oneToManyProject.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.oneToManyProject.business.abstracts.ILangService;
import kodlama.io.oneToManyProject.business.requests.CreateLangRequest;
import kodlama.io.oneToManyProject.business.responses.GetAllLangsResponse;

@RestController
@RequestMapping(name = "/api/langs")
public class LangController {

	ILangService langService;
	
	@Autowired
	public LangController(ILangService langService) {
		this.langService = langService;
	}
	
	@RequestMapping(name="/all")
	List<GetAllLangsResponse> getAll(){
		return langService.getAll();
	}
	
	@GetMapping(name="/{id}")
	GetAllLangsResponse getById(int id) {
		return langService.getById(id);
	}
	
	@PostMapping(name="/add")
	public void add(CreateLangRequest langRequest)
	{
		langService.add(langRequest);
	}
	
	@PutMapping(name = "/update")
	public void update(CreateLangRequest langRequest,String name) {
		langService.update(langRequest,name);
	}
	
	@DeleteMapping(name="/delete")
	public void delete(int id) {
		langService.delete(id);
	}
	
}
