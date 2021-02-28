package com.example.mobilelele.init;


import com.example.mobilelele.models.dtos.ModelSeedDto;
import com.example.mobilelele.services.ModelServices;
import com.example.mobilelele.services.UserRolesService;
import com.example.mobilelele.utils.FileUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static com.example.mobilelele.constants.GlobalConstants.MODELS_FILE_PATH;


@Component
public class AppInit implements CommandLineRunner {
    private final Gson gson;
    private final ModelServices modelServices;
    private final FileUtil fileUtil;
    private final UserRolesService userRolesService;


    @Autowired
    public AppInit(Gson gson, ModelServices modelServices, FileUtil fileUtil, UserRolesService userRolesService) {
        this.gson = gson;
        this.modelServices = modelServices;
        this.fileUtil = fileUtil;
        this.userRolesService = userRolesService;
    }

    @Override
    public void run(String... args) throws Exception {
//        this.seedModels();
//        this.addRoles();
    }

    private void addRoles() {
        this.userRolesService.addRoles();
    }

    private void seedModels() throws FileNotFoundException {
        ModelSeedDto[] dtos = this.gson.fromJson(new FileReader(MODELS_FILE_PATH), ModelSeedDto[].class);
        this.modelServices.seedModels(dtos);
    }

}
