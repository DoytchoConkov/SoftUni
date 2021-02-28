package com.example.demo.models.dtos;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserWithBuyerDTO {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Set<ProductInfoDTO> productInfoDTOSet;

    public UserWithBuyerDTO() {
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

    public Set<ProductInfoDTO> getProductInfoDTOSet() {
        return productInfoDTOSet;
    }

    public void setProductInfoDTOSet(Set<ProductInfoDTO> productInfoDTOSet) {
        this.productInfoDTOSet = productInfoDTOSet;
    }
}
