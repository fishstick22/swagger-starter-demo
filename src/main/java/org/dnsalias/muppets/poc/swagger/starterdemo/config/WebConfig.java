package org.dnsalias.muppets.poc.swagger.starterdemo.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    ServletRegistrationBean<WebServlet> h2servletRegistration(){
        ServletRegistrationBean<WebServlet> registrationBean 
        	= new ServletRegistrationBean<WebServlet>( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
