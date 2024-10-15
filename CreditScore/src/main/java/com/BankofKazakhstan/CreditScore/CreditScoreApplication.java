package com.BankofKazakhstan.CreditScore;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDiscoveryClient
@SpringBootApplication

public class CreditScoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditScoreApplication.class, args);
	}

}
