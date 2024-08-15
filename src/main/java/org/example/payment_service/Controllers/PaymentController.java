package org.example.payment_service.Controllers;


import com.razorpay.RazorpayException;
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
        String payment=null;
        try {
            payment= paymentService.intiatePayment(
                    requestDto.getName(),
                    requestDto.getOrderId(),
                    requestDto.getAmount()
            );
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
        return payment;
    }


}
