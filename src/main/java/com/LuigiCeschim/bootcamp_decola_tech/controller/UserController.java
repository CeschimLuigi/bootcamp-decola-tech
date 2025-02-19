package com.LuigiCeschim.bootcamp_decola_tech.controller;

import com.LuigiCeschim.bootcamp_decola_tech.domain.model.User;
import com.LuigiCeschim.bootcamp_decola_tech.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){

        var user = service.findById(id);

        return ResponseEntity.ok(user);

    }

    @PostMapping
    public ResponseEntity<User> findById(@RequestBody User user){

        var userCreated = service.create(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(userCreated);

    }


}
