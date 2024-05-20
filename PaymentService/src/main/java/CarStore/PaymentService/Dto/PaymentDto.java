package CarStore.PaymentService.Dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentDto {
    private Long id;

    private Long BookingId;

    @NotBlank
    private  String CreditCard;

    @NotNull
    private  Double Amount;

    @NotBlank
    private  String  Status;

    @NotNull
    private String PaymentMethod;

    @NotNull
    private  String PaymentDate;

    @NotNull
    private  Long transactionId;
}
