package com.java.finan_certo_app_java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.finan_certo_app_java.model.User;
import com.java.finan_certo_app_java.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user){
        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new RuntimeException("Usuário já existe com esse email!");
        }

        if (user.getSenha() == null || user.getSenha().length() < 8){
            throw new RuntimeException("Senha fraca!");
        }

        if(!user.getSenha().matches(".*[A-Z].*")){
            throw new RuntimeException("A senha deve conter pelo menos uma letra maiúscula!");
        }

        if(!user.getSenha().matches(".*[a-z].*")){
            throw new RuntimeException("A senha deve conter pelo menos uma letra minúscula!");
        }

        if(!user.getSenha().matches(".*\\d.*")){
            throw new RuntimeException("A senha deve conter pelo menos um número!");
        }

        if(!user.getSenha().matches(".*[@#$%^&+=!].*")){
            throw new RuntimeException("A senha deve conter pelo menos um caractere especial!");
        }
        
        return userRepository.save(user);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User findByNome(String nome){
        return userRepository.findByNome(nome);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

}
