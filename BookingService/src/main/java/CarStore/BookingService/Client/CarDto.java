package CarStore.BookingService.Client;

import lombok.Data;

@Data
public class CarDto {
    private Long Id;
    private String Model;
    private String VehicleBrand;
    private String Availability;
}
