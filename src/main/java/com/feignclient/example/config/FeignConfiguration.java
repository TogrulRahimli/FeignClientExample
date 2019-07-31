package com.feignclient.example.config;

import com.feignclient.example.client.UserClient;
import feign.codec.ErrorDecoder;
import feign.error.AnnotationErrorDecoder;
import feign.jackson.JacksonDecoder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(clients = {UserClient.class})
//@EnableFeignClients(basePackages = "com.feignclient.example.client")
public class FeignConfiguration {

    @Bean
    public ErrorDecoder feignErrorDecoder() {
        return AnnotationErrorDecoder.builderFor(UserClient.class)
                .withResponseBodyDecoder(new JacksonDecoder())
                .build();
    }
}
