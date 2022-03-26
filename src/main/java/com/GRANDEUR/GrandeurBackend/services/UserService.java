package com.GRANDEUR.GrandeurBackend.services;

import com.GRANDEUR.GrandeurBackend.exceptions.UserNotFoundException;
import com.GRANDEUR.GrandeurBackend.models.User;
import com.GRANDEUR.GrandeurBackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService{
    private final UserRepository userRepository; // Instantiating the repository //

    @Autowired // dependency injection //
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // method to add user to the database //
    public User addUser(User user){
        return userRepository.save(user);
    }


    // method to fetch all users //
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    // method to update user //
    public User updateUser(User user){
        return userRepository.save(user);
    }

    // method to find employee by id //
    public User findUserById(Long id){
        return userRepository.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id "+id+" doesn't exist")); // Throwing an exception if there exists no user with that name //
    }

    // method to delete an user //
    public void deleteUser(Long id){
        userRepository.deleteUserById(id); // auto querying our method since JPA repository by default does not have delete by ID //
    }


}
