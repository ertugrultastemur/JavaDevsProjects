package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.IPLangService;
import kodlama.io.Devs.business.concretes.PLangManager;
import kodlama.io.Devs.dataAccess.concretes.InMemoryPLangRepository;
import kodlama.io.Devs.entities.concretes.PLang;

@RestController
@RequestMapping("/api/plang")
public class PLangsController {
	IPLangService pLangService;

	@Autowired
	public PLangsController(IPLangService pLangService) throws Exception{
		super();
		this.pLangService = pLangService;
	}
	@GetMapping("/getall")
	public List<PLang> getAll() throws Exception{
		PLangManager pLangManager = new PLangManager(new InMemoryPLangRepository());
		pLangManager.getAll();
		
		return pLangService.getAll();
		
		}
	
}
