package me.project.configurations;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfigurations {

	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder()
				.group("API")
				.pathsToMatch("https://todosimple-production.up.railway.app/**")
				.build();
	}
}
