package com.covid.covid.repository;

import com.covid.covid.model.Activite;
import com.covid.covid.model.Lieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface LieuRepository extends JpaRepository<Lieu, Long> {

    @Query("SELECT l FROM Lieu l WHERE l.nomActivite = :nomActivite")
    List<Lieu> findLieuByNomActivite(@Param("nomActivite") String nomActivite);

    @Query("SELECT l FROM Lieu l WHERE l.idLieu = :id")
    List<Lieu> findLieuByIdLieu(@Param("id") int id);

}
