package CarStore.BookingService.Service;


import CarStore.BookingService.Dto.CreateBookingDto;
import CarStore.BookingService.Dto.ResponseBookingDto;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public interface BookingService {
    ResponseBookingDto createBooking(CreateBookingDto createBookingDto) throws NotFoundException;
    ResponseBookingDto getBookingById(Long id) throws NotFoundException;
    ResponseBookingDto ConfirmenBooking(Long bookingId);


}
