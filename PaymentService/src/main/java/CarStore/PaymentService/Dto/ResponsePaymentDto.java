package CarStore.PaymentService.Dto;

import CarStore.PaymentService.Enum.PaymentMethod;
import CarStore.PaymentService.Enum.PaymentStatus;
import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record ResponsePaymentDto(Long idBooking,
                                Long idClient,
                                Long transactionId,
                                String creditCard,
                                Double amount,
                                PaymentStatus status,
                                PaymentMethod method,
                                LocalDateTime paymentDate
) {
}
