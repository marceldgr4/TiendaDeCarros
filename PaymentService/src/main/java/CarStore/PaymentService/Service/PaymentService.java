package CarStore.PaymentService.Service;

import CarStore.PaymentService.Dto.PaymentDto;
import CarStore.PaymentService.Entity.Payment;
import CarStore.PaymentService.Mapper.PaymentMapper;
import CarStore.PaymentService.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentMapper paymentMapper;

    public PaymentDto createPayment(PaymentDto paymentDto) {
        Payment payment = paymentMapper.toEntity(paymentDto);
        payment = paymentRepository.save(payment);
        return paymentMapper.toDto(payment);
    }
    public List<PaymentDto> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(paymentMapper::toDto).collect(Collectors.toList());
    }
    public PaymentDto getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        return payment!=null?paymentMapper.toDto(payment):null;

    }
    public PaymentDto updatePayment(Long id, PaymentDto paymentDto) {
        Payment payment = paymentRepository.findById(paymentDto.getId()).orElse(null);
        if(payment!=null){

            payment.setBookingId(paymentDto.getBookingId());
            payment.setCreditCard(paymentDto.getCreditCard());
            payment.setAmount(paymentDto.getAmount());
            payment.setTransactionId(paymentDto.getTransactionId());
            payment.setPaymentMethod(paymentDto.getPaymentMethod());
            payment.setStatus(paymentDto.getStatus());
           return paymentMapper.toDto(payment);
        }else{
            throw  new RuntimeException("Payment not found");
        }

    }
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

}
