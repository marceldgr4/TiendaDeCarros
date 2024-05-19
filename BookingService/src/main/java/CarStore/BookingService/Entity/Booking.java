package CarStore.BookingService.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBooking;

    @Column(nullable = false)
    @NotNull
    private Long idCars;

    @Column(nullable = false)
    @NotNull
    private String Customer_Name;

    @Column(nullable = false)
    @NotNull
    private String Status;

    @Column(nullable = false)
    @NotNull
    private LocalDate StartDate;

    @Column(nullable = false)
    @NotNull
    private LocalDate EndDate;
}
