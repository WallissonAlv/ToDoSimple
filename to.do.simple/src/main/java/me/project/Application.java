package me.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 *  Welcome my web application! This API was builded with those configurations
 * 
 * Technologies:
 * - Java Development Kit 1.8 version
 * - Spring Boot 2.7.12
 * - Starter Data JPA
 * - H2 Database
 * - PostgreSQL
 * - OpenApi(Swagger)
 * - Railway
 * 
 * @Author WallissonAlv
 * */

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
