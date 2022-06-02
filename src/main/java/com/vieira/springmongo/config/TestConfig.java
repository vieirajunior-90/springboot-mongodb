package com.vieira.springmongo.config;

import com.vieira.springmongo.dtos.AuthorDto;
import com.vieira.springmongo.models.Post;
import com.vieira.springmongo.models.User;
import com.vieira.springmongo.repositories.PostRepository;
import com.vieira.springmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User U1 = new User("Carlos Fernandez", "carlosfernandez@gmail.com");
        User U2 = new User("Maria Raspberry", "mariaraspberry@gmail.com");
        User U3 = new User("John Textor", "johntextor@outlook.com");

        userRepository.saveAll(Arrays.asList(U1, U2, U3));

        Post P1 = Post.builder()
                .date(sdf.parse("21/03/2020"))
                .title("Partiu Viagem")
                .body("Vou viajar para São Paulo, abraços!")
                .author(AuthorDto.from(U1))
                .build();

        Post P2 = Post.builder()
                .date(sdf.parse("23/03/2020"))
                .title("Bom dia")
                .body("Acordei feliz hoje!")
                .author(AuthorDto.from(U1))
                .build();

        postRepository.saveAll(Arrays.asList(P1, P2));

        U1.getPosts().addAll(Arrays.asList(P1, P2));
        userRepository.save(U1);
    }
}
