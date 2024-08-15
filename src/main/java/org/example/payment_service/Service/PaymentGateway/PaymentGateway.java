package org.example.payment_service.Service.PaymentGateway;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentGateway {

    String generatePaymentLink(Long orderId ,int amount ,String name) throws RazorpayException, StripeException;

    String generatePaymentLink(Long orderId, String name, int amount) throws StripeException, StripeException, RazorpayException;

    Boolean ValidaetPayment(Long orderId);
}
