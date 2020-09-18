package com.ozair.firstspringproject;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController

public class StringsController {

	
	
	@RequestMapping("/")
	public String strings() {
		return "Hello Client! How are you doing?";
}
	@RequestMapping("/random")
	public String randomtext() {
		return "I hope you like Spring Boot as much as I do!";
}

}
