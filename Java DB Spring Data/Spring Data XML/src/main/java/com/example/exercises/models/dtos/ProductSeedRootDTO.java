package com.example.exercises.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSeedRootDTO {
    @XmlElement(name = "product")
    List<ProductSeedDTO> products;

    public ProductSeedRootDTO() {
    }

    public List<ProductSeedDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSeedDTO> products) {
        this.products = products;
    }
}
