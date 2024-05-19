package CarStore.BookingService.Service;

import CarStore.BookingService.Client.CarDto;
import CarStore.BookingService.Client.CarsClient;
import CarStore.BookingService.Dto.BookingDto;
import CarStore.BookingService.Entity.Booking;
import CarStore.BookingService.Mappper.BookingMapper;
import CarStore.BookingService.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CarsClient carsClient;
    @Autowired
    private BookingMapper bookingMapper;

    public BookingDto CreateBooking(BookingDto bookingDto){
        CarDto car = carsClient.getCarById(bookingDto.getIdCars());
        if (car == null || ! "available".equalsIgnoreCase(car.getAvailability())){
            throw new RuntimeException("car is no available for booking");
        }
        Booking booking = bookingMapper.toEntity(bookingDto);
        booking = bookingRepository.save(booking);
        return bookingMapper.toDto(booking);
    }

    public List<BookingDto> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(bookingMapper::toDto)
                .collect(Collectors.toList());
    }
    public BookingDto getBookingById(Long id){
        Booking booking = bookingRepository.findById(id).orElse(null);
        return booking != null ? bookingMapper.toDto(booking) : null;
    }
    public BookingDto updateBooking(Long id, BookingDto bookingDetails){
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null){
            booking.setIdCars(bookingDetails.getIdCars());
            booking.setCustomer_Name(booking.getCustomer_Name());
            booking.setStatus(bookingDetails.getStatus());
            booking.setStartDate(bookingDetails.getStartDate());
            booking.setEndDate(bookingDetails.getEndDate());
            booking= bookingRepository.save(booking);
            return bookingMapper.toDto(booking);
        }else{
            throw new RuntimeException("booking not found");
        }
    }
    public  void deleteBooking(Long id){
        bookingRepository.deleteById(id);
    }

}
