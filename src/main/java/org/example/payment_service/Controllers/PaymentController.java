package org.example.payment_service.Controllers;


import org.example.payment_service.Dtos.InitiatePaymentRequestDto;
import org.example.payment_service.Service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;
    PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }
    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto requestDto){
        return paymentService.intiatePayment(
                requestDto.getName(),
                requestDto.getOrderId(),
                requestDto.getAmount()
        );
    }


}
