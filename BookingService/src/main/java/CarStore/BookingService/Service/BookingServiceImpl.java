package CarStore.BookingService.Service;

import CarStore.BookingService.Client.CarsClient;
import CarStore.BookingService.Dto.CreateBookingDto;
import CarStore.BookingService.Dto.ResponseBookingDto;
import CarStore.BookingService.Entity.Booking;
import CarStore.BookingService.Exceptions.CarReserveException;
import CarStore.BookingService.Mappper.BookingMapper;
import CarStore.BookingService.Repository.BookingRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookingServiceImpl implements BookingService{
     private final BookingRepository bookingRepository;
     private  final CarsClient carsClient;
     private final BookingMapper bookingMapper;

    public BookingServiceImpl(BookingRepository bookingRepository, CarsClient carsClient, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.carsClient = carsClient;
        this.bookingMapper = bookingMapper;
    }


    @Override
    public ResponseBookingDto createBooking(CreateBookingDto createBookingDto) throws NotFoundException {
        if (createBookingDto.CarsId() == null) {
            throw new NotFoundException("Car ID cannot be null");
        }
        try {
            this.carsClient.carReserve(createBookingDto.CarsId());
        } catch (Exception e) {
            throw new CarReserveException("Car cannot be reserved, check availability at the moment");
        }
        Booking newBooking = this.bookingMapper.CreateBookingDtoToBooking(createBookingDto);
        Booking savedBooking = this.bookingRepository.save(newBooking);
        return this.bookingMapper.bookingToBookingDto(savedBooking);
    }

    @Override
    public ResponseBookingDto getBookingById(Long id) throws NotFoundException {
        Optional<Booking>booking = this.bookingRepository.findById(id);
        if (!booking.isPresent()) throw new NotFoundException();
        return this.bookingMapper.bookingToBookingDto(booking.get());
    }

    @Override
    public ResponseBookingDto ConfirmenBooking(Long bookingId) {
        throw new UnsupportedOperationException("Unimplemented method 'confirmedBooking");
    }
}
