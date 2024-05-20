package CarStore.PaymentService.Mapper;

import CarStore.PaymentService.Dto.PaymentDto;
import CarStore.PaymentService.Entity.Payment;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentDto toDto(Payment payment);
    Payment toEntity(PaymentDto paymentDto);
}
