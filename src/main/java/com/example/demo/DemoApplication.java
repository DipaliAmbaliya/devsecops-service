package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// ❌ XSS Vulnerability
	@GetMapping("/")
	public String home(@RequestParam(defaultValue = "Guest") String name) {
		return "<h1>Hello Test " + name + "</h1>";
	}

	// ❌ Hardcoded secret
	private static final String API_KEY = "HARDCODED-SECRET-123";
}