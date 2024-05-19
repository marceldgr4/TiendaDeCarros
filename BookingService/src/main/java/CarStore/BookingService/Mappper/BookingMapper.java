package CarStore.BookingService.Mappper;

import CarStore.BookingService.Dto.BookingDto;
import CarStore.BookingService.Entity.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {


    BookingDto toDto(Booking booking);
    Booking toEntity(BookingDto bookingDto);

}
