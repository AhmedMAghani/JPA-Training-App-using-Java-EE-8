package com.JPAJakartaEE8.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.Stateful;
import javax.persistence.PrePersist;
import java.io.Serializable;

@Stateful
public class UserSession implements Serializable {


    // lifecycle hookup for ejb this lifecycle method is exists in stateless, singleton and stateful
    // invoked after all the dependence are injected successfully into the been
    @PostConstruct
    public void postConstruct(){

    }

    // lifecycle hookup for ejb this lifecycle method is exists in stateless, singleton and stateful
    // invoked before the been become available to the garbage collection
    @PreDestroy
    public void preDestroy(){

    }

    // lifecycle hookup for ejb this lifecycle method is only available in the stateful ejb
    // invoked before the been is hibernated by the ejb
    @PrePersist
    public void prePasivate(){

    }

    // lifecycle hookup for ejb this lifecycle method is only available in the stateful ejb
    // invoked after the been is activated after hibernation
    @PostActivate
    public void postActivate(){

    }

    public String getCurrentUser(){
        return null;
    }
}
