package exam.services;

import exam.models.entities.Classification;
import exam.models.entities.enums.ClassificaionName;

public interface ClassificationService {
    void initClassification();

    Classification findClassification(ClassificaionName name);
}
