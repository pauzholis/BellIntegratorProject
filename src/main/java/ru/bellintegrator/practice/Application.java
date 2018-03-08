package ru.bellintegrator.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ImportResource("spring_mvc_config.xml")
@SpringBootApplication
//@ComponentScan(basePackageClasses = {DummyControllerImpl.class, DummyServiceImpl.class, PersonDAOImpl.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }

//    @Bean
//    public TaskExecutor controllerPool() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() + 1);
//        executor.setQueueCapacity(25);
//        return executor;
//    }
//
//    @Bean
//    public LocaleResolver localeResolver() {
//        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
//        sessionLocaleResolver.setDefaultLocale(Locale.US);
//        return sessionLocaleResolver;
//    }
//
//    @Bean
//    public Docket postApi() {
//        return new Docket(DocumentationType.SWAGGER_2).groupName("persons").apiInfo(apiInfo()).
//                select().paths(regex("/person.*")).build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Spring REST Sample with Swagger")
//                .description("Spring REST Sample with Swagger")
//                .contact("https://github.com/azEsm/empty_project")
//                .version("1.0")
//                .build();
//    }
}