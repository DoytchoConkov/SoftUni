package workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import workshop.models.entities.Exercise;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise,String> {
    @Query("select e.name from Exercise as e")
    List<String> findByName();
    Exercise findByName(String name);
}
