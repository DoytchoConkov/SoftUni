package com.example.exercises.models.dtos;

import org.hibernate.validator.constraints.Length;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSeedDTO implements Serializable {
    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    @Length(min = 3, message = "Wrong last name!")
    private String lastName;
    @XmlAttribute(name = "age")
    private int age;

    public UserSeedDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
