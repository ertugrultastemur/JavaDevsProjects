package kodlamaIO.rentACar;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlamaIO.rentACar.core.utilities.exceptions.BusinessException;
import kodlamaIO.rentACar.core.utilities.exceptions.ProblemDetails;
import kodlamaIO.rentACar.core.utilities.exceptions.ValidationProblemDetails;

@SpringBootApplication
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
		
	}
	
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
