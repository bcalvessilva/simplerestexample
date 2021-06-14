package br.com.bcalvessilva.greeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GreetingApplication {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);
	}

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	class Greeting {
		private final long id;
		private final String content;

		public Greeting(long id, String content) {
			this.id = id;
			this.content = content;
		}

		public long getId() {
			return id;
		}

		public String getContent() {
			return content;
		}
	}
}