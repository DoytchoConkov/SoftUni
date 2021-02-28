package entities.sales;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="customers")
public class Customer extends BaseEntity {
    private String name;
    private String email;
    private String ceditCardNumber;
    private Set<Sale> sales;

    public Customer() {
    }
    @OneToMany(mappedBy = "customer", targetEntity = Sale.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    @Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "email",nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "credit_card_number",nullable = false)
    public String getCeditCardNumber() {
        return ceditCardNumber;
    }

    public void setCeditCardNumber(String ceditCardNumber) {
        this.ceditCardNumber = ceditCardNumber;
    }
}
