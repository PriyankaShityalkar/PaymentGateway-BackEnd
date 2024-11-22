package com.cloud.module;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "OrderClass")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private Integer quantity;
    private Integer amount;
    private String email;
    private String contact;
}
