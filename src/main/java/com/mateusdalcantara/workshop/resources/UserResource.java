package com.mateusdalcantara.workshop.resources;

import com.mateusdalcantara.workshop.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User mateus = new User("1", "Mateus", "mateus@gmail.com");
        User alcantara = new User("2", "Alcantara", "alcantara@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(mateus, alcantara));
        return ResponseEntity.ok().body(list);

    }
}
