package net.javaguides.springboot_restfull_webservices.service;

import net.javaguides.springboot_restfull_webservices.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUserDetails(User user);

    void deleteUser(Long id);
}
