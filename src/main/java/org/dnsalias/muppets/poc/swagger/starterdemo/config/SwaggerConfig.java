package org.dnsalias.muppets.poc.swagger.starterdemo.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.dnsalias.muppets.poc.swagger.starterdemo.controller"))
                .paths(regex("/api/.*"))
                .build()
                .apiInfo(metaData())
                .tags(
                	new Tag("AS Programs", "Maintain Communication Programs"),
                	new Tag("AS Programs Profiles", "Maintain Program \"Profile\""),
                	new Tag("Clients", "View Client Details"),
                	new Tag("Clients Communication Configuraton", "Maintain Client Communication Rules "),
                	new Tag("Clients Profile Exceptions", "Maintain Client Profile Exceptions"),
                	new Tag("Communcations", "View Communications Details"),
                	new Tag("Program Communication Configuration", "Maintain Program Communication Rules")
                );
    }
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Spring Boot REST API Demo")
                .description("\"Spring Boot REST API for Communication Programs\"")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("fishstick22", "https://fishstick22.github.io/", ""))
                .build();
    }
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
