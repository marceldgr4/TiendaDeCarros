package CarStore.CarService.Service;

import CarStore.CarService.Dto.CarReserver_reposonse;
import CarStore.CarService.Dto.CreateCarDto;
import CarStore.CarService.Dto.ResponsesCarDto;
import CarStore.CarService.Entity.Cars;
import CarStore.CarService.Mapper.CarsMapper;
import CarStore.CarService.Repository.CarsRepositoy;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService_Impl implements CarsService{

    private  CarsRepositoy carsRepositoy;
    private  CarsMapper carsMapper;

    @Override
    public ResponsesCarDto create(CreateCarDto createCarDto) {
        Cars cars = this.carsMapper.CreateCarDto_To_Car(createCarDto);
        Cars savadCars = this.carsRepositoy.save(cars);
        return this.carsMapper.carsToResponseCarDto(savadCars);
    }

    @Override
    public List<ResponsesCarDto> listAvailable() {
        return this.carsMapper.carsToCarsDto(this.carsRepositoy.findAllByAvailability());
    }

    @Override
    public CarReserver_reposonse reserveCar(long id) throws NotFoundException {
        Optional<Cars> cars = this.carsRepositoy.findById(id);
        if(!cars.isPresent()|| cars.get().getAvailability()== false) throw new NotFoundException();
        cars.get().setAvailability(false);
        this.carsRepositoy.save(cars.get());

        return this.carsMapper.carsToCarReserve_response(cars.get());
    }

    @Override
    public void returnCars(long id) {
        Optional<Cars> cars = this.carsRepositoy.findById(id);
        if(!cars.isPresent())throw  new NotFoundException();
        cars.get().setAvailability( true);

    }
}
