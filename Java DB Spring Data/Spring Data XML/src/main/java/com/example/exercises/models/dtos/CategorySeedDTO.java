package com.example.exercises.models.dtos;

import org.hibernate.validator.constraints.Length;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategorySeedDTO implements Serializable {
    @XmlAttribute(name = "name")
    @Length(min = 3, max = 15, message = "Wrong category name!")
    private String name;

    public CategorySeedDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
