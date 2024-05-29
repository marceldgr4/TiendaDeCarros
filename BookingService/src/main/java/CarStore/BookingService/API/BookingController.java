package CarStore.BookingService.API;

import CarStore.BookingService.Dto.CreateBookingDto;
import CarStore.BookingService.Dto.ResponseBookingDto;
import CarStore.BookingService.Service.BookingServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/booking")
@AllArgsConstructor
public class BookingController {

    private final BookingServiceImpl bookingService;

    @PostMapping("")
    public ResponseEntity<ResponseBookingDto> postMethodName(@RequestBody CreateBookingDto createBookingDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.bookingService.createBooking(createBookingDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBookingDto> getBookingById(@PathVariable Long id){
        try{
            ResponseBookingDto booking = this.bookingService.getBookingById(id);
            return ResponseEntity.ok().body(booking);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
