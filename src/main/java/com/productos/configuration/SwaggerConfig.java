package com.productos.configuration;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Configuracion para SWAGGER_2
 * @author abi_l
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.productos.controller"))
                .paths(PathSelectors.any())
                //.paths(regex("api/productos/*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        @SuppressWarnings("rawtypes")
		ApiInfo apiInfo = new ApiInfo(
                "API REST Productos",
                "API REST de Abigail Hernandez",
                "1.0",
                "",
                new Contact("Abigail Hernandez", "https://github.com/filipebrener",
                        "abigailhdezleon@gmail.com"),
                "",
                "", new ArrayList<VendorExtension>()
        );
    return apiInfo;
    }

}
