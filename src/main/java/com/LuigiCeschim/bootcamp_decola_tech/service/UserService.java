package com.LuigiCeschim.bootcamp_decola_tech.service;

import com.LuigiCeschim.bootcamp_decola_tech.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User user);




}
