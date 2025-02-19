package com.LuigiCeschim.bootcamp_decola_tech.service.impl;

import com.LuigiCeschim.bootcamp_decola_tech.domain.model.User;
import com.LuigiCeschim.bootcamp_decola_tech.domain.repository.UserRepository;
import com.LuigiCeschim.bootcamp_decola_tech.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private final UserRepository repository;


    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    @Transactional
    public User create(User user) {
        if (repository.existsByAccountNumber(user.getAccount().getNumber())){
            throw new IllegalArgumentException("This account number already exists");
        }
        return repository.save(user);
    }
}
