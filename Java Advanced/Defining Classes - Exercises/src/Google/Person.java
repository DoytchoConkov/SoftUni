package Google;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Person {
    public String getFullName() {
        return fullName;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Children> getChildrens() {
        return childrens;
    }

    private String fullName;

    private Car car;
    private Company company;
    private List<Pokemon> pokemon;
    private List<Parent> parents;
    private List<Children> childrens;

    public Person(String name) {
        this.fullName = name;
        this.company=new Company();
        this.car=new Car();
        this.pokemon = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.childrens = new ArrayList<>();
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public Company getCompany() {
        return company;
    }
}
