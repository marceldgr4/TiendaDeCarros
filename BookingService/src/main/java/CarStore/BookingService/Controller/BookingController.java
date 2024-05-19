package CarStore.BookingService.Controller;

import CarStore.BookingService.Dto.BookingDto;
import CarStore.BookingService.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public BookingDto createBooking(@RequestBody BookingDto bookingDto) {
        return bookingService.CreateBooking(bookingDto);
    }
    @GetMapping
    public List<BookingDto> getAllBookings() {
        return bookingService.getAllBookings();
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable Long id) {
        BookingDto bookingDto = bookingService.getBookingById(id);
        return bookingDto != null ? ResponseEntity.ok(bookingDto) : ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<BookingDto> updateBooking(@PathVariable Long id, @RequestBody BookingDto bookingDetails) {
        return ResponseEntity.ok(bookingService.updateBooking(id,bookingDetails));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
