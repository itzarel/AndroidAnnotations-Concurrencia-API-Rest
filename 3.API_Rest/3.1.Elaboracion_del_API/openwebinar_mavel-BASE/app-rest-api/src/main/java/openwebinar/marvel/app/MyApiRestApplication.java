package openwebinar.marvel.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



/*
 *
 * /------------------------------------------------\
 * | Generate new project: https://start.spring.io/ |
 * |------------------------------------------------|
 * |------------------------------------------------|
 * |   - Dependencies:                              |
 * |       - Web                                    |
 * |       - JDBC                                   |
 * |       - H2                                     |
 * |       - DevTools                               |
 * \------------------------------------------------/
 *
 *
 * END POINT: http://localhost:8080/avengers
 * DB: http://localhost:8080/h2-console
 */

@SpringBootApplication
public class MyApiRestApplication extends SpringBootServletInitializer implements WebApplicationInitializer, WebMvcConfigurer {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApiRestApplication.class, args);
    }
}
