package workshop.models.bindingModels;

import workshop.models.entities.Exercise;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

public class HomeworkBindingModel {
    private String exercise;
    private LocalDateTime addedOn;
    private String gitAddress;

    public HomeworkBindingModel() {
    }

    @NotNull
    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    @NotBlank
    @Pattern(regexp = "https:\\/github.com\\/.*")
    public String getGitAddress() {
        return gitAddress;
    }

    public void setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
    }
}
