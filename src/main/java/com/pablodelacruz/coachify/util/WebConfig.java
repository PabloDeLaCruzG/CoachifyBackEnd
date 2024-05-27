package com.pablodelacruz.coachify.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
        registry.addMapping("/**") // Permitimos solicitudes desde todas las rutas
                .allowedOrigins("https://coachify-fitness.web.app", "http://localhost:3000")// Permitimos solicitudes desde el frontend en el puerto 3000
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permitimos los métodos HTTP
                .allowedHeaders("*")
                .allowCredentials(true); // Permitimos todos los encabezados
    }
}

