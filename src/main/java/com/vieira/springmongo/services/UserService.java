package com.vieira.springmongo.services;

import com.vieira.springmongo.dtos.UserDto;
import com.vieira.springmongo.models.User;
import com.vieira.springmongo.repositories.UserRepository;
import com.vieira.springmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }
    @Transactional
    public User insert(User user) {
        return userRepository.insert(user);
    }

    public User fromDto(UserDto userDto) {
        return new User(userDto.name(), userDto.email());
    }

}
