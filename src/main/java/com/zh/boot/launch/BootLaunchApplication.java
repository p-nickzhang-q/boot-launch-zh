package com.zh.boot.launch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
/**
 * 注入xml的bean
 */
@ImportResource(locations = {"classpath:beans.xml"})
public class BootLaunchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootLaunchApplication.class, args);
    }

}
