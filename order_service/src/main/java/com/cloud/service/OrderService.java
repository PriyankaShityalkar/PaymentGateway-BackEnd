package com.cloud.service;

import com.cloud.module.Order;
import com.cloud.module.dtos.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService
{
    Payment createOrder(Order order);

    List<Order> getAllOrders();
}
