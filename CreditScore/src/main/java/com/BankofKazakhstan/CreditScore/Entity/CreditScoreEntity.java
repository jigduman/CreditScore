package com.BankofKazakhstan.CreditScore.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="creditors")
@Data

public class CreditScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="client_name")
    private String name;

    @Column(name="client_phone")
    private String phone;

    @Column(name="client_age")
    private int age;

    @Column(name="client_creditscore")
    private int creditscore;

    @Column(name="client_currentcredits")
    private int currentcredits;
}
