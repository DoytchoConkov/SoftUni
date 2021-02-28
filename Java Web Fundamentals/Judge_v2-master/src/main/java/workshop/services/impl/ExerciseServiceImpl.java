package workshop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import workshop.models.entities.Exercise;
import workshop.models.services.ExerciseServiceModel;
import workshop.repositories.ExerciseRepository;
import workshop.services.ExerciseService;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(ExerciseServiceModel exerciseServiceModel) {
        this.exerciseRepository.save(modelMapper.map(exerciseServiceModel, Exercise.class));
    }

    @Override
    public List<String> getAll() {
        return this.exerciseRepository.findByName();
    }

    @Override
    public Exercise getByName(String exercise) {
        return this.exerciseRepository.findByName(exercise);
    }
}
