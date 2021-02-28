package exam.models.bindings;


import exam.models.entities.CategoryName;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ItemAddBindingModel {
    private String name;
    private String description;
    private BigDecimal price;
    private CategoryName category;
    private String Gender;

    public ItemAddBindingModel() {
    }

    @NotBlank(message = "Name can not be empty")
    @Size(min = 2, message = "Name length must be more than two characters.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "Description can not be empty")
    @Size(min = 3, message = "Description length must be more than three characters.")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DecimalMin(value = "0", message = "Price must be positive")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull(message = "Choose category")
    public CategoryName getCategory() {
        return category;
    }

    public void setCategory(CategoryName category) {
        this.category = category;
    }

    @NotBlank(message = "Choose gender")
    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
