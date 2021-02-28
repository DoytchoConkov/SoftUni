package com.example.mobilelele.models.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    private String name;

   private List<Model> models;

    public Brand() {
    }

    public Brand(String name, LocalDateTime created, LocalDateTime modified) {
        this.name = name;
        super.setCreated(created);
        super.setModified(modified);
        this.models = new ArrayList<>();
    }

    @Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "brand")
    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
}
