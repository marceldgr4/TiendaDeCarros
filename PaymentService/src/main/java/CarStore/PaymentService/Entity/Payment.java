package CarStore.PaymentService.Entity;

import CarStore.PaymentService.Enum.PaymentMethod;
import CarStore.PaymentService.Enum.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    @Column(nullable = false)
    private Long idBooking;

    @Column(nullable = false)
    private Long idClient;

    @Column(nullable = false)
    private  Long transactionId;

    @Column(nullable = false)
    private  String CreditCard;

    @Column(nullable = false)
    private  Double Amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus Status;

    @Enumerated(EnumType.STRING)
    private PaymentMethod Method;

    @Column(nullable = false)
    private  String PaymentDate;



}
