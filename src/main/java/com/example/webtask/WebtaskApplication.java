package com.example.webtask;

import com.example.webtask.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class WebtaskApplication{
	public static void main(String[] args) {
		SpringApplication.run(WebtaskApplication.class, args);
	}
}
