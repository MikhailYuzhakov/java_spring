package ru.yuzhakov.hw4task2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("ru.yuzhakov.hw4task2.model")
public class Hw4task2Application {

	public static void main(String[] args) {
		SpringApplication.run(Hw4task2Application.class, args);
	}

}
