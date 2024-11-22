package com.cloud.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paymentStatus;
    private String transactionId;
    private String orderId;
    private Integer amount;
    private String currency;
    private  String access_key;
    private String fullname;

    public Payment( String fullname,String orderId, Integer amount, String currency, String access_key) {
       this.fullname=fullname;
        this.orderId = orderId;
        this.amount = amount;
        this.currency = currency;
        this.access_key = access_key;
    }
}
