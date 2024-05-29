package CarStore.BookingService.Client;

import CarStore.BookingService.Config.FeignClientConfig;

import CarStore.BookingService.Dto.CarReserveResponse.CarReserveResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "cars-service",url= "http://localhost:8080",configuration = FeignClientConfig.class)
public interface CarsClient {
    @PostMapping(value = "/api/Car-Service/reserve",consumes = MediaType.APPLICATION_JSON_VALUE)
    CarReserveResponse carReserve(@RequestParam Long id);

}
