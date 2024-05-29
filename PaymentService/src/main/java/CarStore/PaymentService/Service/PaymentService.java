package CarStore.PaymentService.Service;


import CarStore.PaymentService.Dto.CreartePaymentDto;
import CarStore.PaymentService.Dto.ResponsePaymentDto;
import CarStore.PaymentService.Enum.PaymentStatus;
import org.springframework.stereotype.Service;



@Service
public interface PaymentService {
    ResponsePaymentDto crearPayment(CreartePaymentDto paymentDto);
    ResponsePaymentDto getPaymentById(Long id);
    void UpdatePaymentStatus(Long id, PaymentStatus status);




}
