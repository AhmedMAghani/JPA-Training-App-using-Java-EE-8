package com.JPAJakartaEE8.Conf;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer {
    @PersistenceContext(unitName = "JPAJakartaEE8PU")
    EntityManager entityManager;

    @Produces
    public EntityManager entityManager(){
        return entityManager;
    }
}
