package com.sortiz.datajpa.app.springdatajpa.app;

import jakarta.faces.webapp.FacesServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        ServletRegistrationBean servletRegistrationBean =
                new ServletRegistrationBean(servlet, "*.jsf", "*.xhtml");
        return servletRegistrationBean;
    }
}
