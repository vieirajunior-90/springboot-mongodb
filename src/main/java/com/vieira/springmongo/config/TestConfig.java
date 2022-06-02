package com.vieira.springmongo.config;

import com.vieira.springmongo.models.User;
import com.vieira.springmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) {

        userRepository.deleteAll();

        User U1 = new User("Carlos Fernandez", "carlosfernandez@gmail.com");
        User U2 = new User("Maria Raspberry", "mariaraspberry@gmail.com");
        User U3 = new User("John Textor", "johntextor@outlook.com");
        userRepository.saveAll(Arrays.asList(U1, U2, U3));
    }
}
