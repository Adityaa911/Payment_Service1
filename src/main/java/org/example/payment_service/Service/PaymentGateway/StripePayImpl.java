package org.example.payment_service.Service.PaymentGateway;

import org.springframework.stereotype.Service;

@Service
public class StripePayImpl implements PaymentGateway{
    @Override
    public String generatePaymentLink(Long orderId, int amount, String name) {
        return "";
    }

    @Override
    public Boolean ValidaetPayment(Long orderId) {
        return null;
    }
}
