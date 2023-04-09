package kodlamaIO.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface IModelMapperService {
	ModelMapper forRequest();
	ModelMapper forResponse();

}
