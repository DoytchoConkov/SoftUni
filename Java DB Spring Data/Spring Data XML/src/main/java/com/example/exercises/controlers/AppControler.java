package com.example.exercises.controlers;

import com.example.exercises.constants.GlobalConstants;
import com.example.exercises.models.dtos.*;
import com.example.exercises.services.CategoryServices;
import com.example.exercises.services.ProductServices;
import com.example.exercises.services.UserServices;
import com.example.exercises.utils.FileUtil;
import com.example.exercises.utils.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

import static com.example.exercises.constants.GlobalConstants.PRODUCT2_FILE_XML_PATH;

@Component
public class AppControler implements CommandLineRunner {
    private final CategoryServices categoryServices;
    private final ProductServices productServices;
    private final UserServices userServices;
    private final FileUtil fileUtil;
    private final XmlParser xmlParser;
    private final Random random;

    @Autowired
    public AppControler(CategoryServices categoryServices, ProductServices productServices, UserServices userServices, FileUtil fileUtil, XmlParser xmlParser, Random random) {
        this.categoryServices = categoryServices;
        this.productServices = productServices;
        this.userServices = userServices;
        this.fileUtil = fileUtil;
        this.xmlParser = xmlParser;
        this.random = random;
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


    }

    private void writeProductsInRange() throws JAXBException {
        List<ProductInRangeDTO> product = this.productServices.getProductsInRange();

        ProductInRangeRootDTO productInRangeRootDTO = new ProductInRangeRootDTO();
        product.forEach(pr -> {
            productInRangeRootDTO.getProducts().add(pr);
        });
        this.xmlParser.marshalToFile(PRODUCT2_FILE_XML_PATH, productInRangeRootDTO);

    }

    private void seedUsers() throws JAXBException, FileNotFoundException {
        UserSeedRootDTO userSeedRootDTO = xmlParser.unmarshalFromFile(GlobalConstants.USER_FILE_XML_PATH, UserSeedRootDTO.class);
        this.userServices.usersSeed(userSeedRootDTO.getUserSeedDTOList());
    }

    private void seedCategories() throws JAXBException, FileNotFoundException {
        CategorySeedRootDTO categorySeedDTO = xmlParser.unmarshalFromFile(GlobalConstants.CATEGORY_FILE_XML_PATH, CategorySeedRootDTO.class);
        this.categoryServices.seedCategory(categorySeedDTO.getCategorySeedDTOList());
    }

    private void seedProducts() throws JAXBException, FileNotFoundException {
        ProductSeedRootDTO productSeedDTO = xmlParser.unmarshalFromFile(GlobalConstants.PRODUCT_FILE_XML_PATH, ProductSeedRootDTO.class);
        this.productServices.seedProduct(productSeedDTO.getProducts());
    }
}
