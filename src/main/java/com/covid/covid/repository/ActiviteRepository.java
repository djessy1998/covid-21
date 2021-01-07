package com.covid.covid.repository;

import com.covid.covid.model.Activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActiviteRepository extends JpaRepository<Activite, Long> {

    @Query("SELECT a FROM Activite a WHERE a.userId = :idUser")
    List<Activite> findActivite(@Param("idUser") int idUser);

    @Query("SELECT a FROM Activite a WHERE a.idActivite = :id")
    List<Activite> findActiviteById(@Param("id") int id);

    @Query("SELECT a FROM Activite a WHERE a.nomLieu = :nomLieu")
    List<Activite> findActiviteByNomLieu(@Param("nomLieu") String nomLieu);

}
