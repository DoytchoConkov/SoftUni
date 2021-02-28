package com.example.demo.controlers;

import com.example.demo.constants.GlobalConstants;
import com.example.demo.models.dtos.*;
import com.example.demo.services.CategoryServices;
import com.example.demo.services.ProductServices;
import com.example.demo.services.UserServices;
import com.example.demo.utils.FileUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import static com.example.demo.constants.GlobalConstants.PRODUCT2_FILE_PATH;

@Component
public class AppControler implements CommandLineRunner {
    private final CategoryServices categoryServices;
    private final ProductServices productServices;
    private final UserServices userServices;
    private final Gson gson;
    private final FileUtil fileUtil;

    @Autowired
    public AppControler(CategoryServices categoryServices, ProductServices productServices, UserServices userServices, Gson gson, FileUtil fileUtil) {
        this.categoryServices = categoryServices;
        this.productServices = productServices;
        this.userServices = userServices;
        this.gson = gson;
        this.fileUtil = fileUtil;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedCategories();
        this.seedUsers();
        this.seedProducts();

        this.writeProductsInRange();
        this.getUsersWithBuyers();

    }

    private void getUsersWithBuyers() {
        Set<ProductWithBuyerDTO> users = this.productServices.getProductWithBuyers();
    //    List<ProductInfoDTO> userWithBuyer=this.productServices.getListOfSellers(users);
        System.out.println();
    }

    private void writeProductsInRange() throws IOException {
        List<ProductInRangeDTO> product = this.productServices.getProductsInRange();

        String json = this.gson.toJson(product);
        this.fileUtil.write(json, PRODUCT2_FILE_PATH);
    }

    private void seedUsers() throws FileNotFoundException {
        UserSeedDTO[] dtos = this.gson.fromJson(new FileReader(GlobalConstants.USER_FILE_PATH), UserSeedDTO[].class);
        this.userServices.seedUsers(dtos);
    }

    private void seedProducts() throws FileNotFoundException {
        ProductSeedDTO[] dtos = this.gson.fromJson(new FileReader(GlobalConstants.PRODUCT_FILE_PATH), ProductSeedDTO[].class);
        this.productServices.seedProducts(dtos);
    }

    private void seedCategories() throws FileNotFoundException {
        CategorySeedDTO[] dtos = this.gson.fromJson(new FileReader(GlobalConstants.CATEGORY_FILE_PATH), CategorySeedDTO[].class);
        this.categoryServices.seedCategories(dtos);
    }
}
