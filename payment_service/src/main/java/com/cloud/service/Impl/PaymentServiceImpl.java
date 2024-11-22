package com.cloud.service.Impl;

import com.cloud.module.Payment;
import com.cloud.repository.PaymentRepository;
import com.cloud.service.PaymentService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService
{
    @Autowired
    private PaymentRepository paymentRepository;

    private static final String ACCESS_KEY = "rzp_test_SCO1EwtS1TIsW2";
    private static final String SECRET_KEY = "II4oblDZDwP3ytzeFy3eLXTF";
    @Override
    public Payment createPayment(Payment payment) throws RazorpayException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("amount", payment.getAmount()*100);
        jsonObject.put("currency", "INR");
        RazorpayClient razorpayClient = new RazorpayClient(ACCESS_KEY, SECRET_KEY);
        Order order = razorpayClient.orders.create(jsonObject);
        Payment payment1 = prepareTransactionDeatils(order);
        payment1.setPaymentStatus(payment.getPaymentStatus());
        payment1.setTransactionId(payment.getTransactionId());
        payment1.setFullname(payment.getFullname());
        paymentRepository.save(payment1);
        return payment1;
    }

    public Payment prepareTransactionDeatils(Order order)
    {
        String fullname=order.get("fullname");
        String orderId = order.get("id");
        Integer amount = order.get("amount");
        String key = order.get("key");
        String currency = order.get("currency");
        return new Payment(fullname,orderId,amount,currency,ACCESS_KEY);
    }
}
