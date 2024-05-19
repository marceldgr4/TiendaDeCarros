package CarStore.BookingService.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingDto {
    private Long idBooking;
    @NotNull
    private Long idCars;

    @NotBlank
    private String customerName;

    @NotBlank
    private String Status;

    @NotNull
    private LocalDate StartDate;
    @NotNull
    private LocalDate EndDate;

}
