package ru.yuzhakov.resource_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    /**
     * Правила фильтрации
     * @param http защищенный http запрос
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()) //требование аутентификации для всех видов запросов
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(Customizer.withDefaults())); //с использованием jwt токена
        return http.build();
    }

}
