package net.javaguides.springboot_restfull_webservices.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot_restfull_webservices.entity.User;
import net.javaguides.springboot_restfull_webservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody  User user) {
        User savedUser = userService.createUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/get-user-{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User savedUser = userService.getUserById(id);
        return new ResponseEntity<User>(savedUser, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<User>>  getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    @PutMapping("/update-user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUserDetails(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete-{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
