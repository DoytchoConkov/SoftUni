package com.example.exercises.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductInRangeRootDTO {
    @XmlElement(name = "product")
    List<ProductInRangeDTO> products = new ArrayList<>();

    public ProductInRangeRootDTO() {
    }

    public List<ProductInRangeDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInRangeDTO> products) {
        this.products = products;
    }
}
