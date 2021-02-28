package com.example.exercises.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategorySeedRootDTO {
    @XmlElement(name = "category")
    List<CategorySeedDTO> categorySeedDTOList;

    public CategorySeedRootDTO() {
    }

    public List<CategorySeedDTO> getCategorySeedDTOList() {
        return categorySeedDTOList;
    }

    public void setCategorySeedDTOList(List<CategorySeedDTO> categorySeedDTOList) {
        this.categorySeedDTOList = categorySeedDTOList;
    }
}
