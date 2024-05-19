package CarStore.CarService.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CarDto {
    private Long idCars;
    private String Model;
    private String vehicleBrand;
    private String availability;
}
