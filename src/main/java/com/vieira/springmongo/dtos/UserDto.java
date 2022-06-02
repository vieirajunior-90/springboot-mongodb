package com.vieira.springmongo.dtos;

import com.vieira.springmongo.models.User;

import java.io.Serial;
import java.io.Serializable;
public record UserDto(String id, String name, String email) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public static UserDto convert(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail());
    }
}

