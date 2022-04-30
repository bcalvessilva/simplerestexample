package br.com.curtaocodigo.detectbeanclasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GreetingApplication {

	@Autowired
	private String applicationName;
	
	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);
	}

	@GetMapping("/greeting")
	public Greeting greeting() {
		return new Greeting(applicationName);
	}
	
	class Greeting {
		private final String content;

		public Greeting(String content) {
			this.content = content;
		}

		public String getContent() {
			return content;
		}
	}
}