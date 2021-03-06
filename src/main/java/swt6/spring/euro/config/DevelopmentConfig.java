package swt6.spring.euro.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevelopmentConfig {

	@Bean
	public CommandLineRunner databaseInitialzer() {
		return new DatabaseInitializer();
	}
}
