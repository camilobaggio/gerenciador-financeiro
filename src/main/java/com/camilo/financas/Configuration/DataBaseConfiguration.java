package com.camilo.financas.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.beans.factory.annotation.Value;


@Configuration
public class DataBaseConfiguration {

   
    @Value("${spring.datasource.url}")
    String Url;
    @Value("${spring.datasource.username}")
    String UserName;
    @Value("${spring.datasource.password}")
    String Password;
    @Value("${spring.datasource.driver-class-name}")
    String Driver;
}






