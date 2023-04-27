package com.sbi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.sbi.demo.entity.URLData;

@SpringBootApplication
public class UrlCreatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlCreatorApplication.class, args);
	}
	

}
