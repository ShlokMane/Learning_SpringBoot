package net.javaguides.springboot_restfull_webservices.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot_restfull_webservices.entity.User;
import net.javaguides.springboot_restfull_webservices.respository.UserRepository;
import net.javaguides.springboot_restfull_webservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        User user =  userRepository.findById(id).get();
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUserDetails(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return updatedUser;


    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
