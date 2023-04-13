package kodlamaIO.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
	

	@NotNull
	@NotBlank
	private String plate;
	
	@NotNull
	@NotBlank
	private double DailyPrice;
	
	@NotNull
	@NotBlank
	private int modelYear;
	
	@NotNull
	@NotBlank
	private int state;
	
	@NotNull
	@NotBlank
	private int modelId;
}
