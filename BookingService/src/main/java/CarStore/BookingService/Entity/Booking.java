package CarStore.BookingService.Entity;

import CarStore.BookingService.Enums.BookingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long idBooking;

    @Column(nullable = false)
    @NotNull
    private Long CarsId;

    @Column(nullable = false)
    @NotNull
    private Long CustomerId;

   @Enumerated(EnumType.STRING)
   private BookingStatus Status;

  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime StartDate;

  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime EndDate;
}
