package CarStore.PaymentService.Mapper;

import CarStore.PaymentService.Dto.CreartePaymentDto;
import CarStore.PaymentService.Dto.ResponsePaymentDto;
import CarStore.PaymentService.Entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface PaymentMapper {
    @Mapping(target = "id", ignore = true)
    ResponsePaymentDto toDto(Payment payment);
    Payment toEntity(CreartePaymentDto creartePaymentDto);
}
