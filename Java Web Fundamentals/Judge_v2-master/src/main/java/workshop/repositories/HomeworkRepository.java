package workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import workshop.models.entities.Homework;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework,String> {
}
