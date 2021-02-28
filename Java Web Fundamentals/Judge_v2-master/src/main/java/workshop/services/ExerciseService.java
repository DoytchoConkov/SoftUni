package workshop.services;

import workshop.models.entities.Exercise;
import workshop.models.services.ExerciseServiceModel;

import java.util.List;

public interface ExerciseService {
    void add(ExerciseServiceModel map);

    List<String> getAll();

    Exercise getByName(String exercise);
}
