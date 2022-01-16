package com.example.securitydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
    }

}

/*
    TODO 1 Remember Me - możliwość identyfikacji użytkownika w kilku sesjach

    To zadanie nie ma rozwiązania - zadanie sprawdza umiejętność samodzielnego rozwiązywania problemów,
    w oparciu o ogólnie dostępne tutoriale.

    Opcja podstawowa - remember me w oparciu o ciasteczka, extras: z użyciem bazy danych.

    Poniżej przykładowe artykuły:

    Użycie ciasteczek:
    https://www.baeldung.com/spring-security-remember-me

    Użycie bazy danych:
    https://www.baeldung.com/spring-security-persistent-remember-me

 */