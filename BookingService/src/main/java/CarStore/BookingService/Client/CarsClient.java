package CarStore.BookingService.Client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cars-service")
public interface CarsClient {
    @GetMapping("/api/cars/{id}")
    @CircuitBreaker(name = "carsClient",fallbackMethod = "fallbackGetCarById")
    @Retry(name = "carsClient")
    CarDto getCarById(@PathVariable("id") Long id);

    default CarDto fallbackGetCarById(Long id, Throwable throwable) {
        CarDto carDto = new CarDto();
        carDto.setId(id);
        carDto.setModel("Fallback Model");
        carDto.setVehicleBrand("Fallback Brand");
        carDto.setAvailability("unavailable");
        return carDto;
    }
}
