package com.mateusdalcantara.workshop.config;

import com.mateusdalcantara.workshop.domain.Post;
import com.mateusdalcantara.workshop.domain.User;
import com.mateusdalcantara.workshop.repository.PostRepository;
import com.mateusdalcantara.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {


    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User mateus = new User(null, "Mateus D.A.", "mat@gmail.com", "(71) 9996543");
        User alcantara = new User(null, "Alcantara P.", "alcantara@gmail.com", "(71) 9996333");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Paritu viajar", "Vou viajar para SP. Abraços!", mateus);
        Post post2 = new Post(null, sdf.parse("01/01/2026"), "Conclui meu estudo!", "Vou para a formatura. Abraços!", mateus);

        userRepository.saveAll(Arrays.asList(mateus, alcantara));
        postRepository.saveAll(Arrays.asList(post1, post2));

    }
}
