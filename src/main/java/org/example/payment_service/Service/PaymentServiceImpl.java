package org.example.payment_service.Service;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.example.payment_service.Service.PaymentGateway.PaymentGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

    private PaymentGateway paymentGateway;

    PaymentServiceImpl(@Qualifier("razorPayImpl") PaymentGateway paymentGateway){
        this.paymentGateway=paymentGateway;
    }
    @Override
    public String intiatePayment(String name, Long orderId, int amount) throws RazorpayException, StripeException {
        return paymentGateway.generatePaymentLink(
                orderId, amount, name);
    }
}
