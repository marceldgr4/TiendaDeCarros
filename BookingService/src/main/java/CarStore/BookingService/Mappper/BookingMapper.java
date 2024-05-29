package CarStore.BookingService.Mappper;

import CarStore.BookingService.Dto.BookingDto;
import CarStore.BookingService.Dto.CreateBookingDto;
import CarStore.BookingService.Dto.ResponseBookingDto;
import CarStore.BookingService.Entity.Booking;
import CarStore.BookingService.Enums.BookingStatus;
import org.apache.coyote.Response;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookingMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "StartDate", ignore = true)
    @Mapping(target = "EndDate",ignore = true)
    @Mapping(target = "Status",ignore = true)

    Booking CreateBookingDtoToBooking(CreateBookingDto createBookingDto);
    ResponseBookingDto bookingToBookingDto(Booking booking);

    default BookingStatus EN_ESPERA_DE_PAGO() {
        return BookingStatus.EN_ESPERA_DE_PAGO;
    }

    BookingDto toDto(Booking booking);
    Booking toEntity(BookingDto bookingDto);

}
