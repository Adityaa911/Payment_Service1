package org.example.payment_service.Service.PaymentGateway;

import com.razorpay.RazorpayException;

public interface PaymentGateway {

    String generatePaymentLink(Long orderId ,int amount ,String name) throws RazorpayException;

    Boolean ValidaetPayment(Long orderId);
}
