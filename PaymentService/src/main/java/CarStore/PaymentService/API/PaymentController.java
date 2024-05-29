package CarStore.PaymentService.API;

import CarStore.PaymentService.Dto.CreartePaymentDto;
import CarStore.PaymentService.Dto.ResponsePaymentDto;
import CarStore.PaymentService.Enum.PaymentStatus;
import CarStore.PaymentService.Service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentController {
    private PaymentService paymentService;

    @PostMapping("")
    public ResponseEntity<ResponsePaymentDto> createPayment(@RequestBody CreartePaymentDto creartePaymentDto) {
        ResponsePaymentDto response = paymentService.crearPayment(creartePaymentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsePaymentDto> getPaymentById(@PathVariable Long id) {
        ResponsePaymentDto response = paymentService.getPaymentById(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updatePaymentStatus(@PathVariable Long id, @RequestParam String status) {
        paymentService.UpdatePaymentStatus(id, PaymentStatus.valueOf(status));
        return ResponseEntity.noContent().build();
    }

}
