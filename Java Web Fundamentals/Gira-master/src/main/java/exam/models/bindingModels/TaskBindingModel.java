package exam.models.bindingModels;

import exam.models.entities.enums.ClassificaionName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class TaskBindingModel {
    private String name;
    private String description;
    private ClassificaionName classification;
    private LocalDate dueDate;

    public TaskBindingModel() {
    }

    @NotBlank(message = "Name can not be null.")
    @Size(min = 3, max = 20, message = "Name length must be between two and twenty characters.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "Description can not be null.")
    @Size(min = 5, max = 20, message = "Description must be more than five characters.")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull(message = "Please choose Classification.")
    public ClassificaionName getClassification() {
        return classification;
    }

    public void setClassification(ClassificaionName classification) {
        this.classification = classification;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Date must be in present or future")
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
