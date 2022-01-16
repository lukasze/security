package com.example.securitydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService users() {
        // The builder will ensure the passwords are encoded before saving in memory
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        UserDetails user = users
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        UserDetails admin = users
                .username("admin")
                .password("password")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
         /*
                    TODO 3 Zmień konfigurację HttpSecurity - ustaw stronę do logowania na własną
                    (zamiast domyślnej, dostarczanej przez Spring Security)

                    Ustaw Spring Security, żeby przepuszczał wszystkie request'y na '/login',
                    a usunięcie uzytkownika, tylko dla użytkowników z rolą ADMIN
                    (dodaj takiego użytkownika w metodzie configureGlobal)
                    Zrestartuj aplikację i sprawdź czy własna strona logowania jest dostępna

                    https://docs.spring.io/spring-security/reference/5.7/servlet/authentication/passwords/in-memory.html

                 */
        http
                .authorizeRequests()
                .antMatchers("/delete/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll();
    }
}

