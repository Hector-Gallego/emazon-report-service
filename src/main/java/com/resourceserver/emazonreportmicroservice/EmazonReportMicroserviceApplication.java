package com.resourceserver.emazonreportmicroservice;

import com.resourceserver.emazonreportmicroservice.configuration.security.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class EmazonReportMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmazonReportMicroserviceApplication.class, args);
    }

}
