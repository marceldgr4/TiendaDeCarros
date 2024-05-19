package CarStore.CarService.Controller;

import CarStore.CarService.Dto.CarDto;
import CarStore.CarService.Service.CarsService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {

    private CarsService carsService;

    @GetMapping
    public List<CarDto> getAllCars(){
        return carsService.getAllCars();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarsById(@PathVariable Long id){
        return carsService.getCarById(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public CarDto createCar(@RequestBody CarDto carDto){
        return carsService.addCar(carDto);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CarDto> deleteCar(@PathVariable Long id){
        carsService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
