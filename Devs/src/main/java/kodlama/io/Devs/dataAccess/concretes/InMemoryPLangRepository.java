package kodlama.io.Devs.dataAccess.concretes;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.IPLangRepository;
import kodlama.io.Devs.entities.concretes.PLang;

@Repository
public class InMemoryPLangRepository implements IPLangRepository{
	PLang pLang;
	List<PLang> pLangs;
	
	@Autowired
	public InMemoryPLangRepository() {
		
		pLangs = new ArrayList<PLang>();
		add(0,"java");
		add(1,"c++");
		add(2,"python");
		update(1, "C#");
		
		
	}
	

	@Override
	public void add(int id, String name) {
		
		pLangs.add(new PLang(id,name));
	}

	@Override
	public void update(int id,String name) {
		for (PLang pLang : pLangs) {
			if(pLang.getId()==id) {
				pLang.setName(name);
			}
		}
		System.out.println("InMemory : Güncellendi");

	}

	@Override
	public void delete(int id) {
		pLangs.remove(id);
	}

	@Override
	public List<PLang> getAll() {
		return pLangs;
//		for (PLang pLang : pLangs) {
//			pLangs.get(pLang.getId());
//		}
	}

	@Override
	public void getById(int id) {

		pLangs.get(id);
	}

}
