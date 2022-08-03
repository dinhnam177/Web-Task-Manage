package com.example.webtask;

import com.example.webtask.mapper.TaskMapper;
import com.example.webtask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class WebtaskApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(WebtaskApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

	}
}
