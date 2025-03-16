package com.java.finan_certo_app_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.finan_certo_app_java.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByNome(String nome);
    User findByEmail(String email);
}
