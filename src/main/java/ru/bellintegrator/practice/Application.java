package ru.bellintegrator.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.bellintegrator.practice.config.MailConfiguration;
import ru.bellintegrator.practice.config.SecurityConfig;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ImportResource("spring_mvc_config.xml")
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableScheduling
@Import({SecurityConfig.class, MailConfiguration.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }
}