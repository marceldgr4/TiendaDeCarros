package CarStore.BookingService.Dto;

import CarStore.BookingService.Enums.BookingStatus;

import java.time.LocalDateTime;

public record ResponseBookingDto(Long idBooking,
                                 Long CarsId,
                                 Long CustomerId,
                                 BookingStatus Status,
                                 LocalDateTime StarDate,
                                 LocalDateTime EndDate) {
}
