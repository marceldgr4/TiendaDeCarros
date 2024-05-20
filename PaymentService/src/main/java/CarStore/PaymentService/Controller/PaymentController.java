package CarStore.PaymentService.Controller;

import CarStore.PaymentService.Dto.PaymentDto;
import CarStore.PaymentService.Service.PaymentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public PaymentDto createPayment(@RequestBody PaymentDto paymentDto) {
        return paymentService.createPayment(paymentDto);

    }
    @GetMapping
    public List<PaymentDto> getAllPayments() {
        return paymentService.getAllPayments();
    }
    @GetMapping
    public ResponseEntity<PaymentDto> getPaymentById(@PathVariable Long id) {
        PaymentDto payment = paymentService.getPaymentById(id);
        return payment!=null? ResponseEntity.ok(payment) : ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<PaymentDto> updatePayment(@PathVariable Long id, @RequestBody PaymentDto paymentDto) {
        return ResponseEntity.ok(paymentService.updatePayment(id,paymentDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}
