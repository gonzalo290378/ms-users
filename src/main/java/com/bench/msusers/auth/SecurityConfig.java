package com.bench.msusers.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authHttp) -> authHttp
                        .requestMatchers(HttpMethod.GET, "/authorized").permitAll()
                        //.requestMatchers(HttpMethod.GET, "/").hasAnyAuthority("SCOPE_read", "SCOPE_write")
                        //.requestMatchers(HttpMethod.POST, "/").hasAuthority("SCOPE_write")
                        .requestMatchers(HttpMethod.GET, "/", "/static/**", "/index.html", "/api/v1/users/username/{username}").permitAll()
                        //.requestMatchers(HttpMethod.GET, "/api/users/login", "/api/users/{username}", "/api/users/logout", "/api/customers", "/api/storages").authenticated()
                        //.requestMatchers(HttpMethod.POST, "/api/customers", "/api/storages").authenticated()
                        //.requestMatchers(HttpMethod.PUT, "/api/customers/{id}", "/api/storages/{id}").authenticated()
                        //.requestMatchers(HttpMethod.DELETE, "/api/users/{id}", "/api/storages/{id}", "/api/customers/{id}").authenticated()
                        .requestMatchers(HttpMethod.GET, "/").hasAnyAuthority("SCOPE_read", "SCOPE_write")
                        //.requestMatchers(HttpMethod.POST, "/").hasAuthority("SCOPE_write")
                        //.anyRequest().denyAll()
                        .anyRequest().authenticated())
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2Login(login -> login.loginPage("/oauth2/authorization/frontend-app"))
                .oauth2Client(withDefaults())
                .oauth2ResourceServer(resourceServer -> resourceServer.jwt(withDefaults()));
        return http.build();
    }

}