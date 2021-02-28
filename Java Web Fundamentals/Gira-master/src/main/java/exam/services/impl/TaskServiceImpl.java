package exam.services.impl;

import exam.models.bindingModels.TaskBindingModel;
import exam.models.entities.Classification;
import exam.models.entities.Task;
import exam.models.entities.enums.ProgressName;
import exam.models.security.CurrentUser;
import exam.models.view.TaskViewModel;
import exam.repositories.TaskRepository;
import exam.services.ClassificationService;
import exam.services.TaskService;
import exam.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final ModelMapper modelMapper;
    private final TaskRepository taskRepository;
    private final ClassificationService classificationService;
    private final CurrentUser currentUser;
    private final UserService userService;

    public TaskServiceImpl(ModelMapper modelMapper, TaskRepository taskRepository,
                           ClassificationService classificationService, CurrentUser currentUser,
                           UserService userService) {
        this.modelMapper = modelMapper;
        this.taskRepository = taskRepository;
        this.classificationService = classificationService;
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @Override
    public void addTask(TaskBindingModel taskBindingModel) {
        Task task = modelMapper.map(taskBindingModel, Task.class);
        Classification classification = this.classificationService.findClassification(taskBindingModel.getClassification());
        task.setClassification(classification);
        task.setUser(this.userService.findByEmail(currentUser.getUsername()));
        task.setProgress(ProgressName.OPEN);
        this.taskRepository.save(task);
    }

    @Override
    public List<TaskViewModel> viewAll() {
        return this.taskRepository.findAll().stream().map(t -> modelMapper.map(t, TaskViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public void updateTask(Long id) {
        Task task = this.taskRepository.findById(id).orElse(null);
        switch (task.getProgress()) {
            case OPEN:
                task.setProgress(ProgressName.IN_PROGRESS);
                this.taskRepository.save(task);
                break;
            case IN_PROGRESS:
                task.setProgress(ProgressName.COMPLETED);
                this.taskRepository.save(task);
                break;
            case COMPLETED:
                this.taskRepository.delete(task);
                break;
        }
    }
}
