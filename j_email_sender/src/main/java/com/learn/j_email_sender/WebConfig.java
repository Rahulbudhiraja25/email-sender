package com.learn.j_email_sender;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply to all endpoints
                .allowedOriginPatterns("http://127.0.0.1:5500", "http://localhost:5500","https://restro-bro.netlify.app/","https://rahulbudhiraja.diy/","rahulbudhiraja.diy","www.rahulbudhiraja.diy") // Allow frontend URL
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true) // Allow credentials (cookies, HTTP authentication)
                .maxAge(3600); // Cache CORS pre-flight request for 1 hour
    }
}
