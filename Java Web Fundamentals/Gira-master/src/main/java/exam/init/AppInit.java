package exam.init;

import exam.services.ClassificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppInit implements CommandLineRunner {
    private final ClassificationService classificationService;

    public AppInit(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.initClassification();
    }

    private void initClassification() {
        this.classificationService.initClassification();
    }
}
