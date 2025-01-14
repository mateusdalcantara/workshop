package com.mateusdalcantara.workshop.services;

import com.mateusdalcantara.workshop.domain.User;
import com.mateusdalcantara.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired //Automatic instance, spring boot will find the definition of repository
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
}


