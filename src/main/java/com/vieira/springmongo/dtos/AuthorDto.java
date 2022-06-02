package com.vieira.springmongo.dtos;

import com.vieira.springmongo.models.User;

import java.io.Serial;
import java.io.Serializable;

public record AuthorDto(String id, String name) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public static AuthorDto from(User user) {
        return new AuthorDto(user.getId(), user.getName());
    }
}
