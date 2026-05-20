package com.sfg.biasca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Pagine pubbliche — accessibili da tutti
                        .requestMatchers(
                                "/",
                                "/settori",
                                "/settore/**",
                                "/news",
                                "/eventi",
                                "/gare",
                                "/contatti",
                                "/css/**",
                                "/js/**",
                                "/img/**",
                                "/login",
                                "/error",
                                "/h2-console/**",
                                "/admin/**"
                        ).permitAll()

                        // Pannello admin — solo ADMIN
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        // Tutto il resto richiede autenticazione
                        .anyRequest().authenticated()
                )

                // Pagina di login personalizzata
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/admin/settori", true)
                        .failureUrl("/login?error=true")
                        .permitAll()
                )

                // Logout
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}