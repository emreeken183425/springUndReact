package com.dailycodework.demo.service;


import com.dailycodework.demo.model.User;
import com.dailycodework.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
      return userRepository.save(user);
    }



    @Override
    public User updateUser(User user, Long id) {
        return userRepository.findById(id).map(us->{
            us.setUsername(user.getUsername());
            us.setEmail(user.getEmail());
            us.setPassword(user.getPassword());
            return userRepository.save(us);
        }).orElseThrow(()->new RuntimeException("User not found"));
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found"));
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User Not Found"+id);
        }
        userRepository.deleteById(id);
    }
}
