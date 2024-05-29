package CarStore.CarService.API;

import CarStore.CarService.Dto.CarReserver_reposonse;
import CarStore.CarService.Dto.CreateCarDto;
import CarStore.CarService.Dto.ResponsesCarDto;
import CarStore.CarService.Service.CarService_Impl;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Cars")
@AllArgsConstructor
public class CarsController {
    private final CarService_Impl carService;
    @GetMapping("/Availability")
    public ResponseEntity<List<ResponsesCarDto>> listResponseEntity(){
        return ResponseEntity.ok().body(this.carService.listAvailable());
    }
    @PostMapping("")
    public ResponseEntity<ResponsesCarDto> crear(@RequestBody  CreateCarDto createCarDto){
        return  ResponseEntity.status(HttpStatus.CREATED).body(this.carService.create(createCarDto));
        
    }
    @PostMapping("/reveserve")
    public ResponseEntity<CarReserver_reposonse> postMethodName(@RequestParam Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.carService.reserveCar(id));
    }
    @PostMapping("/return")
    public ResponseEntity<String> returnCars(@RequestParam Long id){
        this.carService.returnCars(id);
        return  ResponseEntity.ok().body("the cars returns ok");
    }
}