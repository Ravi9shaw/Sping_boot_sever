package com.textbond.targetapp.service;

import com.textbond.targetapp.dto.UserRegisterRequest;
import com.textbond.targetapp.model.User;
import com.textbond.targetapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(UserRegisterRequest user) {
        User userEntity = new User(user.getUsername(),user.getEmail(),user.getUsername(),user.getRole());
        return userRepository.save(userEntity);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll().stream()
                .map(uer -> new User(uer.getUsername(),uer.getEmail(),uer.getUsername(),uer.getRole()))
                .toList();
    }

}
