package exam.services;

import exam.models.bindingModels.TaskBindingModel;
import exam.models.view.TaskViewModel;

import java.util.List;

public interface TaskService {
    void addTask(TaskBindingModel map);

    List<TaskViewModel> viewAll();

    void updateTask(Long id);
}
