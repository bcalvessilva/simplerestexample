package br.com.curtaocodigo.detectbeanclasses.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "br.com.curtaocodigo.detectbeanclasses")
@RestController
public class GreetingApplication {

	@Autowired
	private String greetingFromConfig;
	
	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);
	}

	@GetMapping("/greeting")
	public Greeting greeting() {
		return new Greeting(greetingFromConfig);
	}
	
	class Greeting {
		private final String greet;

		public Greeting(String content) {
			this.greet = content;
		}

		public String getGreet() {
			return greet;
		}
	}
}