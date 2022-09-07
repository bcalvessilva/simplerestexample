package br.com.curtaocodigo.apisnapratica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication(scanBasePackages ="br.com.curtaocodigo.apisnapratica")
public class ApisNaPraticaApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApisNaPraticaApplication.class, args);
	}
}