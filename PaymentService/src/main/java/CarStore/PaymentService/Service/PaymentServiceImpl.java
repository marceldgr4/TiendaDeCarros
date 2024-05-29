package CarStore.PaymentService.Service;

import CarStore.PaymentService.Dto.CreartePaymentDto;
import CarStore.PaymentService.Dto.ResponsePaymentDto;
import CarStore.PaymentService.Entity.Payment;
import CarStore.PaymentService.Enum.PaymentStatus;
import CarStore.PaymentService.Mapper.PaymentMapper;
import CarStore.PaymentService.Repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentServiceImpl  implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public ResponsePaymentDto crearPayment(CreartePaymentDto paymentDto) {
       Payment payment = paymentMapper.toEntity(paymentDto);
       Payment savedPayment = paymentRepository.save(payment);
        return paymentMapper.toDto(savedPayment);
    }

    @Override
    public ResponsePaymentDto getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(()-> new RuntimeException("payment not found"));
        return paymentMapper.toDto(payment);
    }

    @Override
    public void UpdatePaymentStatus(Long id, PaymentStatus status) {
        Payment payment = paymentRepository.findById(id).orElseThrow(()-> new RuntimeException("payment not found"));
        payment.setStatus(PaymentStatus.valueOf(String.valueOf(status)));
        paymentRepository.save(payment);

    }
}
