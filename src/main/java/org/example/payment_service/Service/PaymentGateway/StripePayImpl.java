package org.example.payment_service.Service.PaymentGateway;

import com.razorpay.RazorpayException;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import lombok.Value;
import org.springframework.stereotype.Service;

@Service
public class StripePayImpl implements PaymentGateway{

    @Value("${stripe.api.key}")
    private String stripeAPIKey;


    @Override
    public String generatePaymentLink(Long orderId, int amount, String name) throws RazorpayException, StripeException {
        Stripe.apiKey = stripeAPIKey;

        PriceCreateParams priceCreateParams =
                PriceCreateParams.builder()
                        .setCurrency("inr")
                        .setUnitAmount(1000L)
//                        .setRecurring(
//                                PriceCreateParams.Recurring.builder()
//                                        .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
//                                        .build()
//                        )
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName("Gold Plan").build()
                        )
                        .build();
        Price price = Price.create(priceCreateParams);

//        Map<String, Object> customText = new HashMap<>();
//
//        Map<String, Object> shippingAddress = new HashMap<>();
//        shippingAddress.put("message", "My Shipping Address");
//
//        customText.put("shipping_address", shippingAddress);

        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(2L)
                                        .build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(params);

        return paymentLink.toString();
    }

    @Override
    public String generatePaymentLink(Long orderId, String name, int amount) throws StripeException, StripeException {
        return "";
    }


    @Override
    public Boolean ValidaetPayment(Long orderId) {
        return null;
    }
}
