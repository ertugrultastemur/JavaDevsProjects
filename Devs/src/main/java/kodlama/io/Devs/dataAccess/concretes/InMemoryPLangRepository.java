package kodlama.io.Devs.dataAccess.concretes;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.IPLangRepository;
import kodlama.io.Devs.entities.concretes.PLang;

@Repository
public class InMemoryPLangRepository implements IPLangRepository {
	PLang pLang;
	List<PLang> pLangs;
	
	@Autowired
	public InMemoryPLangRepository() throws Exception{
		
		pLangs = new ArrayList<PLang>();
		add(0,"java");
		add(1,"c#");
		add(2,"python");
		update(0, "c++");
		getById(1);
		
		
	}
	

	@Override
	public void add(int id, String name) throws Exception{
		boolean isValid=true;
		for (PLang pLang : pLangs) {
			if(name.isEmpty()) {
				isValid=false;
				System.out.println("This area cannot be empty.");
				break;
			}
		}
		for (PLang pLang : pLangs) {
				if(name == pLang.getName()) {
					isValid =false;
					System.out.println("This name already exists.");
					break;
				}
		}
		if(isValid==true) pLangs.add(new PLang(id,name));
		
	}

	@Override
	public void update(int id,String name) {
		boolean isValid=true;
		for (PLang pLang : pLangs) {
			if(name.isEmpty()) {
				isValid=false;
				System.out.println("This area cannot be empty.");
				break;
			}
			if(name == pLang.getName()) {
				isValid=false;
				System.out.println("This name already exists.");
			}
			
			
		
		}
		
		if (isValid==true) {
			for (PLang pLang : pLangs) {
				if (pLang.getId() == id && name != pLang.getName()) {
					pLang.setName(name);
					break;
				}
			}
			System.out.println("InMemory : Updated");
		}

	}

	@Override
	public void delete(int id) {
		pLangs.remove(id);
	}

	@Override
	public List<PLang> getAll() {
		return pLangs;

	}

	@Override
	public void getById(int id) {

		pLangs.get(id);
	}

}
