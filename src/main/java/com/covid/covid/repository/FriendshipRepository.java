package com.covid.covid.repository;

import com.covid.covid.model.Friendship;
import com.covid.covid.model.Role;
import com.covid.covid.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FriendshipRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u JOIN u.friends f WHERE f.idUserFriend = :idUser")
    List<User> findFriendships(@Param("idUser") int idUser);
}
