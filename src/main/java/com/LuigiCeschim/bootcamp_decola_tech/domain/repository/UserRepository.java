package com.LuigiCeschim.bootcamp_decola_tech.domain.repository;


import com.LuigiCeschim.bootcamp_decola_tech.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByAccountNumber(String number);
}
