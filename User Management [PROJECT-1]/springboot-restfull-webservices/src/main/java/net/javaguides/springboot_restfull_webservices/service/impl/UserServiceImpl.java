package net.javaguides.springboot_restfull_webservices.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot_restfull_webservices.dto.UserDto;
import net.javaguides.springboot_restfull_webservices.entity.User;
import net.javaguides.springboot_restfull_webservices.mapper.UserMapper;
import net.javaguides.springboot_restfull_webservices.respository.UserRepository;
import net.javaguides.springboot_restfull_webservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);

        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user =  userRepository.findById(id).get();
        UserDto savedUserDto = UserMapper.mapToUserDto(user);
        return savedUserDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> allUsers =  userRepository.findAll();
        List<UserDto> allUserDto = new ArrayList<>();
        for(User user : allUsers) {
            allUserDto.add(UserMapper.mapToUserDto(user));
        }
        return allUserDto;
    }

    @Override
    public UserDto updateUserDetails(UserDto userDto) {
        User existingUser = userRepository.findById(userDto.getId()).get();
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());
        User updatedUser = userRepository.save(existingUser);
        UserDto updatedUserDto = UserMapper.mapToUserDto(updatedUser);
        return updatedUserDto;


    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
