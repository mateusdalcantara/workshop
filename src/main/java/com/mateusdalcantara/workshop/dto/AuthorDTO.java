package com.mateusdalcantara.workshop.dto;

import com.mateusdalcantara.workshop.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
public class AuthorDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;

    public AuthorDTO() {
    }

    public AuthorDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
    }

}
