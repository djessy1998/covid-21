package com.covid.covid.repository;

import com.covid.covid.model.Notification;
import com.covid.covid.model.Role;
import com.covid.covid.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query("SELECT n FROM Notification n WHERE n.idReceveur = :idUser")
    List<Notification> findNotifications(@Param("idUser") int idUser);

    @Query("SELECT n FROM Notification n WHERE n.idReceveur = :idUser and n.type = 'ACTIVE'")
    List<Notification> findActiveNotifications(@Param("idUser") int idUser);

    @Query("SELECT n FROM Notification n WHERE n.idReceveur = :idUser and n.type = 'PASSIVE'")
    List<Notification> findPassiveNotifications(@Param("idUser") int idUser);

}
