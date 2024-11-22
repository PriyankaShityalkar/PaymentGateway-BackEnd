package com.cloud.service;

import com.cloud.module.Payment;
import com.cloud.repository.PaymentRepository;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService
{
   Payment createPayment(Payment payment) throws RazorpayException;
}
