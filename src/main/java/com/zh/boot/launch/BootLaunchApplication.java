package com.zh.boot.launch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * ImportResource
 * 注入xml的bean
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.zh.boot.launch.mapper"})
@ImportResource(locations = {"classpath:beans.xml"})
public class BootLaunchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootLaunchApplication.class, args);
    }

}
