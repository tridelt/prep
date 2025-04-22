package com.example.backend.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;
    @Column(name = "store_id")
    private long storeID;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "address_id")
    private String address;
    @Column(name = "active")
    private boolean active;
    @Column(name = "create_date")
    private LocalDateTime creationDate;
    @Column(name = "last_update")
    private LocalDateTime lastUpdated;


}
