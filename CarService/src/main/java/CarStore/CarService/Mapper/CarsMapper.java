package CarStore.CarService.Mapper;

import CarStore.CarService.Dto.CarDto;
import CarStore.CarService.Entity.Cars;

public class CarsMapper {
    public static CarDto ToDto(Cars cars){
        return CarDto.builder()
                .idCars(cars.getId_Cars())
                .Model(cars.getModel())
                .vehicleBrand(cars.getVehicle_brand())
                .availability(cars.getAvailability())
                .build();

    }
    public static Cars toEntity(CarDto carDto){
        return Cars.builder()
                .Id_Cars(carDto.getIdCars())
                .Model(carDto.getModel())
                .Vehicle_brand(carDto.getVehicleBrand())
                .Availability(carDto.getAvailability())
                .build();
    }
}
