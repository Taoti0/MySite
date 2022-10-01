package com.zoey.site;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zoey.site.mapper")
@Slf4j
public class MySiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySiteApplication.class, args);
        log.info("\nswagger-ui: http://localhost:8080/swagger-ui.html\n" +
                "swagger-doc: http://localhost:8080/doc.html\n");
    }

}
