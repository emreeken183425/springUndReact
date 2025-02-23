package com.dailycodework.demo.service;

import com.dailycodework.demo.model.User;

import java.util.List;

public interface IUserService {

    List<User> getUser();
    User addUser(User user);
    User updateUser(User user,Long id);
    User getUserById(Long id);
    void deleteUser(Long id);
}
