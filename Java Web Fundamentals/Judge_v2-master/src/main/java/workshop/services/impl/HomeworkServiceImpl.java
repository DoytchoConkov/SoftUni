package workshop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import workshop.models.entities.Homework;
import workshop.models.entities.User;
import workshop.models.services.HomeworkServiceModel;
import workshop.repositories.HomeworkRepository;
import workshop.services.ExerciseService;
import workshop.services.HomeworkService;
import workshop.services.UserService;

import java.time.LocalDateTime;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    private final UserService userService;
    private final HomeworkRepository homeworkRepository;
    private final ModelMapper modelMapper;
    private final ExerciseService exerciseService;

    public HomeworkServiceImpl(UserService userService, HomeworkRepository homeworkRepository, ModelMapper modelMapper, ExerciseService exerciseService) {
        this.userService = userService;
        this.homeworkRepository = homeworkRepository;
        this.modelMapper = modelMapper;
        this.exerciseService = exerciseService;
    }

    @Override
    public void add(HomeworkServiceModel homeworkServiceModel) {
        homeworkServiceModel.setAddedOn(LocalDateTime.now());
        User user = this.userService.getCurrentUser();
        homeworkServiceModel.setAuthor(user);
        Homework homework=modelMapper.map(homeworkServiceModel, Homework.class);
        homework.setExercise(this.exerciseService.getByName(homeworkServiceModel.getExercise()));
        this.homeworkRepository.save(homework);
    }
}
