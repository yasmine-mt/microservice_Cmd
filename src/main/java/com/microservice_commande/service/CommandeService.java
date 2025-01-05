package com.microservice_commande.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice_commande.dao.CommandeDao;
import com.microservice_commande.model.Commande;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class CommandeService {

    @Autowired
    private CommandeDao dao;

    public List<Commande> findAll() {
        return dao.findAll();
    }

    public Optional<Commande> findById(int id) {
        return dao.findById(id);
    }

    public Commande save(Commande commande) {
        return dao.save(commande);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public List<Commande> findCommandesFromDate(LocalDate startDate) {
        return dao.findCommandesFromDate(startDate); 
    }
}
