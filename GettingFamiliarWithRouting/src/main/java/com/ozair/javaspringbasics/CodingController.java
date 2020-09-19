package com.ozair.javaspringbasics;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController

public class CodingController {
	
	@RequestMapping("/coding")
	public String welcome() {
		return "Hello Coding Dojo";
}
	@RequestMapping("/coding/python")
	public String python() {
		return "Python/Django was awesome!";
}
	@RequestMapping("/coding/java")
	public String java() {
		return "Java/Spring is better!";
}

}


