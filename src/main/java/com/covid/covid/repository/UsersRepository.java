package com.covid.covid.repository;

import com.covid.covid.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UsersRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u join u.roles r WHERE u.username = :username and r.roleName='USER'")
    List<User> findUser(@Param("username") String username);

    @Query("SELECT u FROM User u join u.roles r WHERE u.username = :username and r.roleName='ADMIN'")
    List<User> findAdmin(@Param("username") String username);

}
