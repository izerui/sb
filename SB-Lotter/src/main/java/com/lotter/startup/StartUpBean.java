package com.lotter.startup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartUpBean implements CommandLineRunner {

	public void run(String... args) {
		System.out.println("startup");
	}
}