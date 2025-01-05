package com.microservice_commande.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.microservice_commande.model.Commande;

import java.time.LocalDate;
import java.util.List;

public interface CommandeDao extends JpaRepository<Commande,Integer> {
    @Query("SELECT c FROM Commande c WHERE c.date >= :startDate")
    List<Commande> findCommandesFromDate(LocalDate startDate);
}