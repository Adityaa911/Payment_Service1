package org.example.payment_service.Confiqs;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RazorpayClientConfig {

   @Value("${razorPay.key.Id}")
    private String razorpayKeyId;

    @Value("${razorPay.key.secret}")
    private String razorpayKeySecret;

    @Bean
     public RazorpayClient getRazorpayClient() throws RazorpayException {
        return new RazorpayClient(razorpayKeyId,razorpayKeySecret);
    }
}
