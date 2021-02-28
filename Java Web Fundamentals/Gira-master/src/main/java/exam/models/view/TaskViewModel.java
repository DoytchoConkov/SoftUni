package exam.models.view;

import exam.models.entities.Classification;
import exam.models.entities.User;
import exam.models.entities.enums.ProgressName;

import java.time.LocalDate;

public class TaskViewModel {
    private String id;
    private String name;
    private User user;
    private ProgressName progress;
    private LocalDate dueDate;
    private Classification classification;

    public TaskViewModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProgressName getProgress() {
        return progress;
    }

    public void setProgress(ProgressName progress) {
        this.progress = progress;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }
}
