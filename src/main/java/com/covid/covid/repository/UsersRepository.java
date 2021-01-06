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

    @Query("SELECT u FROM User u join u.roles r where r.roleName='USER'")
    List<User> findUsers();

    @Query("SELECT u FROM User u JOIN Activite a ON a.userId=u.userId WHERE a.nomLieu = :lieu " +
            "and a.heureDebut >= :heureDebut " +
            "and a.heureFin <= :heureFin " +
            "and not u.userId = :idUser")
    List<User> findUserRisk(@Param("lieu") String lieu,
                            @Param("idUser") long idUser,
                            @Param("heureDebut") int heureDebut,
                            @Param("heureFin") int heureFin);

}
