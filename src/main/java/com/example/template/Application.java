package com.example.template;

import java.util.Map;
import org.apache.logging.log4j.util.Strings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		var app = new SpringApplication(Application.class);
		setCgrConfigIfRequired(app);
		app.run(args);
	}

	private static void setCgrConfigIfRequired(SpringApplication app) {
		if(Strings.isNotBlank(System.getenv("PORT"))){
			app.setDefaultProperties(Map.of(
					"server.port", System.getenv("PORT"),
					"server.address", "0.0.0.0"
					));
		}
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
