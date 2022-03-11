package org.earelin.alexandria.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.earelin.alexandria")
public class AlexandriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlexandriaApplication.class, args);
	}

}
