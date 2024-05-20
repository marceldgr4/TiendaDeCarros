package CarStore.PaymentService.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Paymesnt")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long BookingId;

    @Column(nullable = false)
    private  String CreditCard;

    @Column(nullable = false)
    private  Double Amount;

    @Column(nullable = false)
    private  String  Status;

    @Column(nullable = false)
    private String PaymentMethod;

    @Column(nullable = false)
    private  String PaymentDate;



    @Column(nullable = false)
    private  Long transactionId;

}
