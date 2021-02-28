package entities.sales;

import entities.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name="products")
public class Product extends BaseEntity {

    private String name;
    private double quantity;
    private BigDecimal price;
    private Set<Sale> sales;


    public Product() {
    }
    @OneToMany(mappedBy = "product", targetEntity = Sale.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Sale> getSale() {
        return sales;
    }

    public void setSale(Set<Sale> sales) {
        this.sales = sales;
    }

    @Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "quantity", columnDefinition = "INT UNSIGNED", nullable = false)
    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    @Column(name = "price", columnDefinition = "INT UNSIGNED", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
