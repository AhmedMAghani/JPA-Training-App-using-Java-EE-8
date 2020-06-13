package com.JPAJakartaEE8.Entity;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public class AbstractEntity implements Serializable {

/*
    @TableGenerator(
            name = "seq_table_gen",
            table = "seq_table",
            initialValue = 0,
            pkColumnName = "gen_name",
            valueColumnName = "Pk_value"
    )
    @SequenceGenerator(
            name = "seq_gen",
            sequenceName = "seq",
            initialValue = 1
    )
    @GeneratedValue(generator = "seq_gen")
*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String UserName;
    private Long Version;
    private LocalDateTime createdOn;
    private LocalDateTime UpdatedOn;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return UpdatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        UpdatedOn = updatedOn;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Long getVersion() {
        return Version;
    }

    public void setVersion(Long version) {
        Version = version;
    }
}
