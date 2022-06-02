package com.vieira.springmongo.controllers;

import com.vieira.springmongo.dtos.UserDto;
import com.vieira.springmongo.models.User;
import com.vieira.springmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> list = userService.findAll();
        List<UserDto> listDto = list.stream()
                .map(user -> new UserDto(user.getId(), user.getName(), user.getEmail())).toList();
        return ResponseEntity.status(HttpStatus.OK).body(listDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(UserDto.convert(user));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDto userDto) {
        User user = userService.fromDto(userDto);
        userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDto userDto) {
        User user = userService.fromDto(userDto);
        user.setId(id);
        userService.update(user);
        return ResponseEntity.noContent().build();
    }
}
