package com.cloud.service.Impl;

import com.cloud.module.Order;
import com.cloud.module.dtos.Payment;
import com.cloud.repository.OrderRepository;
import com.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    public RestTemplate restTemplate;

    @Override
    public Payment createOrder(Order order) {
        Order o = orderRepository.save(order);
        Payment payment = new Payment();
        payment.setTransactionId(paymentTransaction());
        payment.setFullname(o.getFullname());
        payment.setPaymentStatus("Success");
        payment.setOrderId(String.valueOf(o.getId()));
        payment.setAmount(o.getAmount());
        Payment response = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/create-payment", payment, Payment.class);
        return response;
    }

    @Override
    public List<Order> getAllOrders()
    {
        return orderRepository.findAll();
    }

    public String paymentTransaction()
    {
        String transaction = UUID.randomUUID().toString();
        return transaction;
    }
}
