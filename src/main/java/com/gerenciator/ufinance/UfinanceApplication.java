package com.gerenciator.ufinance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AutoConfiguration
@SpringBootApplication
public class UfinanceApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(UfinanceApplication.class, args);
	}

}
