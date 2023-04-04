package kodlama.io.Devs.core.logging.concretes;

import kodlama.io.Devs.core.logging.abstracts.ILogger;

public class InMemoryLogger implements ILogger{

	@Override
	public void log(String data) {
		System.out.println(data + ": loglandı.");
		
	}

}
