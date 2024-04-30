package com.suyad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroservicesRedisCacheApplication
{
	public static void main(String[] args) 
	{
		SpringApplication.run(MicroservicesRedisCacheApplication.class, args);
		System.out.println("Redis Client Application has been started Successfully..........");
	}

}
