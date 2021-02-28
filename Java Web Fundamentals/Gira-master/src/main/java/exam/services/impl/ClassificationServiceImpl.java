package exam.services.impl;

import exam.models.entities.Classification;
import exam.models.entities.enums.ClassificaionName;
import exam.repositories.ClassificationRepository;
import exam.services.ClassificationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    private final ClassificationRepository classificationRepository;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void initClassification() {
        if (classificationRepository.count() != 0) {
            return;
        }
        Arrays.stream(ClassificaionName.values()).forEach(c -> {
            Classification classification = new Classification(c, String.format("This is description for %s", c.name()));
            classificationRepository.save(classification);
        });
    }

    @Override
    public Classification findClassification(ClassificaionName name) {
        return this.classificationRepository.findByName(name);
    }
}

