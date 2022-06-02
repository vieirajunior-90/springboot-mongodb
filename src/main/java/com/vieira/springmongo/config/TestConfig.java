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
        User U1 = new User("1", "Carlos", "carlos@gmail.com");
        User U2 = new User("2", "Maria", "maria@gmail.com");

        userRepository.saveAll(Arrays.asList(U1, U2));
    }
}
