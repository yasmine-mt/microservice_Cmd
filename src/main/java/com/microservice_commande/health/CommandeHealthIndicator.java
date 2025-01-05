package com.microservice_commande.health;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.microservice_commande.dao.CommandeDao;

@Component
public class CommandeHealthIndicator implements HealthIndicator {

    @Autowired
    private CommandeDao dao;

    @Override
    public Health health() {
        long count = dao.count();
        if (count > 0) {
            return Health.up().withDetail("message", "Commandes are available").build();
        } else {
            return Health.down().withDetail("message", "No commandes found").build();
        }
    }
}