package com.csi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HrmvalidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmvalidationApplication.class, args);
	}

}
