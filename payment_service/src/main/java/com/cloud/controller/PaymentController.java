package com.cloud.controller;

import com.cloud.module.Payment;
import com.cloud.service.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController
{
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create-payment")
    public Payment createPayment(@RequestBody Payment payment) throws RazorpayException {
        return paymentService.createPayment(payment);
    }
}
