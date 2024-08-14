package org.example.payment_service.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentRequestDto {

    private Long orderId;
    private String name;
    private String phoneNumber;
    private int amount;
}
