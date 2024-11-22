package com.cloud.controller;

import com.cloud.module.Order;
import com.cloud.module.dtos.Payment;
import com.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @PostMapping("/create-order")
    public Payment createOrder(@RequestBody Order order)
    {
        return orderService.createOrder(order);
    }

    @GetMapping("/get-all-orders")
    public List<Order> getAllOrders()
    {
        return orderService.getAllOrders();
    }
}
