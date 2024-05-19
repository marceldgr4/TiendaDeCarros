package CarStore.CarService.Service;

import CarStore.CarService.Dto.CarDto;
import CarStore.CarService.Entity.Cars;
import CarStore.CarService.Mapper.CarsMapper;
import CarStore.CarService.Repository.CarsRepositoy;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarsService {

    private CarsRepositoy carsRepositoy;

     public List<CarDto> getAllCars(){
         return carsRepositoy.findAll().stream()
                 .map(CarsMapper::ToDto).collect(Collectors.toList());

     }
     public Optional<CarDto> getCarById(Long id){
         return carsRepositoy.findById(id).map(CarsMapper::ToDto);
     }
     public CarDto addCar(CarDto carDto){
         Cars cars = CarsMapper.toEntity(carDto);
         return CarsMapper.ToDto(carsRepositoy.save(cars));
     }
     public CarDto updateCar(Long id, CarDto carDetails){
         return carsRepositoy.findById(id)
                 .map(cars -> {
                     cars.setModel(carDetails.getModel());
                     cars.setVehicle_brand(carDetails.getVehicleBrand());
                     cars.setAvailability(cars.getAvailability());
                     return CarsMapper.ToDto (carsRepositoy.save(cars));
                 })
                 .orElseThrow(() -> new ResourceNotFoundException("Car not found with id" + id));
     }
     public void deleteCar(Long id){
         carsRepositoy.findById(id);
     }
}
