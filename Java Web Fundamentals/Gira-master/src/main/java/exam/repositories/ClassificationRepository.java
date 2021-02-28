package exam.repositories;

import exam.models.entities.Classification;
import exam.models.entities.enums.ClassificaionName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long> {
    Classification findByName(ClassificaionName name);
}
