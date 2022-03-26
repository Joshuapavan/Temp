package com.GRANDEUR.GrandeurBackend.repositories;

import com.GRANDEUR.GrandeurBackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    // Used to perform operations on the user such as findAll() , findByID() etc which is present in the interface JPA repo  //

    // Custom query methods //
    void deleteUserById(Long id);
    Optional<User> findUserById(Long id);
}
