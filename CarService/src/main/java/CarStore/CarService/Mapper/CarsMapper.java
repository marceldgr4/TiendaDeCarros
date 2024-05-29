package CarStore.CarService.Mapper;


import CarStore.CarService.Dto.CarReserver_reposonse;
import CarStore.CarService.Dto.CreateCarDto;
import CarStore.CarService.Dto.ResponsesCarDto;
import CarStore.CarService.Entity.Cars;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarsMapper {


    @Mapping(target = "id", ignore = true)
    Cars CreateCarDto_To_Car(CreateCarDto createCarDto);

    CarReserver_reposonse carsToCarReserve_response(Cars cars);
    ResponsesCarDto carsToResponseCarDto(Cars cars);

    @IterableMapping(elementTargetType = ResponsesCarDto.class)
    List<ResponsesCarDto> carsToCarsDto(List<Cars> Cars);

}



