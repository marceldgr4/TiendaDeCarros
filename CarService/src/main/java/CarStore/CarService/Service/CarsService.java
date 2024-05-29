package CarStore.CarService.Service;


import CarStore.CarService.Dto.CarReserver_reposonse;
import CarStore.CarService.Dto.CreateCarDto;
import CarStore.CarService.Dto.ResponsesCarDto;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

public interface CarsService {
    ResponsesCarDto create(CreateCarDto createCarDto);
    List<ResponsesCarDto> listAvailable();
    CarReserver_reposonse reserveCar(long id) throws NotFoundException;
    void returnCars(long id);




}
