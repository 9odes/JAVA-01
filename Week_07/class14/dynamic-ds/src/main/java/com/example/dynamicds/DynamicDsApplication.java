package com.example.dynamicds;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author hugh
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan({"com.example.dynamicds.mapper"})
public class DynamicDsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDsApplication.class, args);
    }

}
