package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.IPLangService;
import kodlama.io.Devs.dataAccess.abstracts.IPLangRepository;
import kodlama.io.Devs.entities.concretes.PLang;

@Service
public class PLangManager implements IPLangService{
	IPLangRepository pLangRepository;
	
	@Autowired
	public PLangManager(IPLangRepository pLangRepository) {
		super();
		this.pLangRepository = pLangRepository;
	}

	@Override
	public void add(int id, String name) throws Exception{
		pLangRepository.add(id, name);
	}

	@Override
	public void update(int id,String name) {
		pLangRepository.update(id, name);
		
	}

	@Override
	public void delete(int id) {
		pLangRepository.delete(id);
		
	}

	@Override
	public List<PLang> getAll() {
		
		return pLangRepository.getAll();
	}

	@Override
	public void getById(int id) {

		pLangRepository.getById(id);
	}

	
	

}
