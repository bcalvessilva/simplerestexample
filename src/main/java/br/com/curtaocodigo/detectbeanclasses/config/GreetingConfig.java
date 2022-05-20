package br.com.curtaocodigo.detectbeanclasses.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingConfig {

    @Bean
    public String greetingFromConfig(){
        return "Greeting from Config";
    }
}
