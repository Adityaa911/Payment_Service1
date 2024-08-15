package org.example.payment_service.Service;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentService {
    String intiatePayment(String name , Long orderId ,int amount) throws RazorpayException, StripeException;
}
