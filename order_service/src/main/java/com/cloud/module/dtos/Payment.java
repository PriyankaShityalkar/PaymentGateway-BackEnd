package com.cloud.module.dtos;

import lombok.Data;

@Data
public class Payment
{
    private String fullname;
    private String paymentStatus;
    private String transactionId;
    private String orderId;
    private Integer amount;
    private String access_key;
    private String currency;

}
