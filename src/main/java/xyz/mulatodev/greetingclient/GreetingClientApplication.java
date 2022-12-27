package xyz.mulatodev.greetingclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@RestController
public class GreetingClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingClientApplication.class, args);
	}

        @Bean
        public RestTemplate restTemplate(RestTemplateBuilder builder){
            return builder.build();
        }
        
        @Bean
        //@GetMapping("/hello")
        public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
            return arg -> {
                String message = restTemplate.getForObject("http://localhost:8080/greeting?name=Gustavo", String.class);
                System.out.println(message);
            };
        }
}
