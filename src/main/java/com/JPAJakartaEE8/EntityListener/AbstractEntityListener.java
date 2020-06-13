package com.JPAJakartaEE8.EntityListener;

import com.JPAJakartaEE8.Entity.AbstractEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class AbstractEntityListener {

    @PrePersist
    private void setCreatedOn(AbstractEntity abstractEntity){
        if (abstractEntity.getCreatedOn() == null)
            abstractEntity.setCreatedOn(LocalDateTime.now());
    }

    @PreUpdate
    private void setUpdatedOn(AbstractEntity abstractEntity){
        if (abstractEntity.getUpdatedOn() == null)
            abstractEntity.setUpdatedOn(LocalDateTime.now());
    }
}
