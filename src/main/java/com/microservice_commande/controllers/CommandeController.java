package com.microservice_commande.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.microservice_commande.model.Commande;
import com.microservice_commande.service.CommandeService;

import java.util.List;

@RestController
@RequestMapping
("/api/commandes")
public class CommandeController {

    @Autowired
    private CommandeService service;

    @GetMapping
    public List<Commande> getAllcommandes(){
        return service.findAll();
    }

    @PostMapping
    public String createcommande(@RequestBody com.microservice_commande.model.Commande commande){
        service.save(commande);
        return "commande added successfuly";
    }
    @GetMapping("/{id}")
    public ResponseEntity<com.microservice_commande.model.Commande> getCommandbyId(@PathVariable int id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public String deleteCommande(@PathVariable int id){
        service.deleteById(id);
        return "commande id: " + id + " deleted successfully";
    }
}