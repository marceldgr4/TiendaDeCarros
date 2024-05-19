package CarStore.BookingService.Repository;

import CarStore.BookingService.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
