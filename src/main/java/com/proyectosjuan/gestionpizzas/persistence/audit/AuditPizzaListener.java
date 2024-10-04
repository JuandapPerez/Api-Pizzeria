package com.proyectosjuan.gestionpizzas.persistence.audit;

import com.proyectosjuan.gestionpizzas.persistence.entity.PizzaEntity;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;

public class AuditPizzaListener {

    @PostPersist
    @PostUpdate
    public void onPostPersist(PizzaEntity entity){
        System.out.println("Pizza with id: " + entity.getIdPizza() + " has been created/updated");
    }

    @PreRemove
    public void onPreRemove(PizzaEntity entity){
        System.out.println("Pizza with id: " + entity.getIdPizza() + " has been deleted");

    }
}
