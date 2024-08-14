package org.example.payment_service.Service.PaymentGateway;

import com.razorpay.PaymentLink;
import org.springframework.stereotype.Service;
import com.razorpay.PaymentLink;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class RazorPayImpl implements PaymentGateway{
    @Override
    public String generatePaymentLink(Long orderId, int amount, String name) throws RazorpayException {

        RazorpayClient razorpay = new RazorpayClient("[YOUR_KEY_ID]", "[YOUR_KEY_SECRET]");
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", 1000); // 10.00
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",true);
       paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by", 1715396752); //Epoch
        paymentLinkRequest.put("reference_id", orderId.toString());
        paymentLinkRequest.put("description","Payment for Scaler class - 11th May");
        JSONObject customer = new JSONObject();
        customer.put("name","Rishi");
        customer.put("contact","7015608331");
        customer.put("email","rishibawankule@gmail.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Some Random Policy");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://www.scaler.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);

        return payment.toString();
    }

    @Override
    public Boolean ValidaetPayment(Long orderId) {
        return null;
    }
}


