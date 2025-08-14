package com.camilo.financas.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.apache.catalina.startup.HostConfig;
import org.springframework.beans.factory.annotation.Value;

import javax.sql.DataSource;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataBaseConfiguration {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

   @Bean
    public DataSource hikariDataSource() {

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setDriverClassName(driver);

        hikariConfig.setMaximumPoolSize(10); //maximo de conexões liberadas
        hikariConfig.setMinimumIdle(1); // tamanho inicial do pool
        hikariConfig.setPoolName("library-db-pool");
        hikariConfig.setMaxLifetime(600000);// 600 mil ms (10 min)
        hikariConfig.setConnectionTimeout(100000);// timeout para conseguir conexão
        hikariConfig.setConnectionTestQuery("select 1");// query de teste

        return new HikariDataSource(hikariConfig);
}

}
