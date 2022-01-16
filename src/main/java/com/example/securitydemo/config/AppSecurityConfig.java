package com.example.securitydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
    TODO Utworzenie klasy konfiguracyjnej dla spring security
    - rozszerz WebSecurityConfigurerAdapter
    - zaimplementuj metodę konfiguracyjną
        - public void configureGlobalSecurity( AuthenticationManagerBuilder authBuilder)
		- AuthenticationManagerBuilder jest wstrzykiwany przez Spring'a

		Użyj builder'a (parametr metody) do skonfigurowania:
		- inMemoryAuthentication
		- user: "user"
		- password: "password"
		- role: "USER"

	- w logach może pojawić się There is no PasswordEncoder mapped for the id "null"
	  Jeśli tak - spróbuj samodzielnie wyszukać w sieci rozwiązanie powyższego problemu.
	  Poniżej jeden z pomocnych artykułów:
	  https://www.baeldung.com/spring-security-5-default-password-encoder

    - Pomocne podczas testów: Jeśli chcesz się wylogować z aplikacji: localhost:8080/logout
      to domyślny adres w spring security, przekieruje na odpowiednią stroną i wyczyści sesję
 */
@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder
                .inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password")
                .roles("USER");
    }
}

