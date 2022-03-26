package com.GRANDEUR.GrandeurBackend.controllers;

import com.GRANDEUR.GrandeurBackend.models.User;
import com.GRANDEUR.GrandeurBackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Specifying it as a rest controller //
@RequestMapping ("/api/users") // path/ Map to access the Api //
public class UserController {

    private final UserService userService;

    @Autowired // dependency injection //
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // api path to get all the users //  GET Request //
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.findAllUsers();  // Getting all the users from the user service //
        return new ResponseEntity<>(users, HttpStatus.OK); // Creating a new response entity from users and passing the response code along with it //
    }

    // api path to get the user based on the provided id //  GET Request //
    @GetMapping("/find/{id}") // getting a user by specific id //
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){ // getting the id from mapped request //
        User user = userService.findUserById(id);  // Getting the user from the user service //
        return new ResponseEntity<>(user, HttpStatus.OK); // Creating a new response entity from users and passing the response code along with it //
    }


    // api path to create / add a user // POST Request //
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) { // type casting the JSON Data into  a user object //
        User newUser = userService.addUser(user); // adding the posted user data to new user //
        return new ResponseEntity<>(newUser,HttpStatus.CREATED); // Returning the response code along with the new user instance //
    }

    // api path to update an existing user // PUT Request //
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) { // type casting the JSON Data into  a user object //
        User updatedUser = userService.updateUser(user); // adding the posted user data to updated user //
        return new ResponseEntity<>(updatedUser,HttpStatus.ACCEPTED); // Returning the response code along with the updated user instance //
    }

    // api path to delete user // DELETE Request //
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){ // getting the id from the user //
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
