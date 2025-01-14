package com.mateusdalcantara.workshop.config;

import com.mateusdalcantara.workshop.domain.User;
import com.mateusdalcantara.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User mateus = new User(null, "Mateus D.A.", "mat@gmail.com");
        User alcantara = new User(null, "Alcantara P.", "alcantara@gmail.com");
        userRepository.saveAll(Arrays.asList(mateus, alcantara));    }
}
