package com.mateusdalcantara.workshop.services;

import com.mateusdalcantara.workshop.domain.User;
import com.mateusdalcantara.workshop.repository.UserRepository;
import com.mateusdalcantara.workshop.services.exception.DataBaseException;
import com.mateusdalcantara.workshop.services.exception.ObjectNotFoundException;
import com.mateusdalcantara.workshop.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired //Automatic instance, spring boot will find the definition of repository
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        return repo.findById(id)  // Assuming repo returns an Optional<User>
                .orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }

    public void delete(Long id) {
        try {
            repo.deleteById(String.valueOf(id));
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }

    }
}




