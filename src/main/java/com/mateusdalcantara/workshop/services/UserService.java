package com.mateusdalcantara.workshop.services;

import com.mateusdalcantara.workshop.domain.User;
import com.mateusdalcantara.workshop.dto.UserDTO;
import com.mateusdalcantara.workshop.repository.UserRepository;
import com.mateusdalcantara.workshop.services.exception.DataBaseException;
import com.mateusdalcantara.workshop.services.exception.ObjectNotFoundException;
import com.mateusdalcantara.workshop.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired //Automatic instance, spring boot will find the definition of repository
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        return repo.findById(String.valueOf((id)))
                .orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }

    public User insert(User obj) {
        return repo.save(obj);
    }

    public void delete(String id) {
        try {
            repo.deleteById(String.valueOf(id));
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public User update(String id, User obj) {
        Optional<User> entityOptional = repo.findById(id); // Correção aqui
        User entity = entityOptional.get(); // Obtém a entidade User
        updateData(entity, obj); // Atualiza os dados da entidade
        return repo.save(entity); // Salva a entidade atualizada e retorna

    }
    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail(), objDto.getPhone());
    }
}




