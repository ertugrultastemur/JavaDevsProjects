package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.PLang;

public interface IPLangService {
	
	void add(int id, String name) throws Exception;
	
	void update(int id,String name);
	
	void delete(int id);
	
	List<PLang> getAll();
	
	void getById(int id);

}
