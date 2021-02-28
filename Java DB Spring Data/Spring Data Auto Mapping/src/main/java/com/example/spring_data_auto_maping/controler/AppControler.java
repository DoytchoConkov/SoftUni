package com.example.spring_data_auto_maping.controler;

import com.example.spring_data_auto_maping.domains.DTOs.GameAddDTO;
import com.example.spring_data_auto_maping.domains.DTOs.GameEditDTO;
import com.example.spring_data_auto_maping.domains.DTOs.UserLoginDTO;
import com.example.spring_data_auto_maping.domains.DTOs.UserRegisteredDTO;
import com.example.spring_data_auto_maping.domains.entities.Game;
import com.example.spring_data_auto_maping.services.GameServices;
import com.example.spring_data_auto_maping.services.UserServices;
import com.example.spring_data_auto_maping.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import javax.validation.ConstraintViolation;
import java.io.BufferedReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class AppControler implements CommandLineRunner {

    private final BufferedReader reader;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserServices userServices;
    private final GameServices gameServices;

    @Autowired
    public AppControler(BufferedReader reader, ModelMapper modelMapper, ValidationUtil validationUtil, UserServices userServices, GameServices gameServices) {
        this.reader = reader;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userServices = userServices;
        this.gameServices = gameServices;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Please, enter command line (<Enter> for exit) : ");
        String input = reader.readLine();
        while (!"".equals(input)) {
            String[] tokens = input.split("\\|");

            switch (tokens[0]) {
                case "RegisterUser":
                    String email = tokens[1];
                    String password = tokens[2];
                    String rePassword = tokens[3];
                    String fullname = tokens[4];
                    if (password.equals(rePassword)) {
                        UserRegisteredDTO userRegisteredDTO = new UserRegisteredDTO(email, password, fullname);
                        if (this.validationUtil.isValid(userRegisteredDTO)) {
                            this.userServices.registerUser(userRegisteredDTO);
                            System.out.printf("%s was registered%n", userRegisteredDTO.getFullName());
                        } else {
                            this.validationUtil.getViolations(userRegisteredDTO)
                                    .stream().map(ConstraintViolation::getMessage)
                                    .forEach(System.out::println);
                        }
                    } else {
                        System.out.println("Passwords does not much !!!");
                    }
                    break;
                case "LoginUser":
                    String loginEmail = tokens[1];
                    String loginPassword = tokens[2];
                    UserLoginDTO userLoginDTO = new UserLoginDTO(loginEmail, loginPassword);
                    this.userServices.loginUser(userLoginDTO);
                    break;
                case "Logout":
                    this.userServices.logoutUser();
                    break;
                case "AddGame":
                    String title = tokens[1];
                    BigDecimal price = new BigDecimal(tokens[2]);
                    double size = Double.parseDouble(tokens[3]);
                    String trailer = tokens[4];
                    String thumbnailURL = tokens[5];
                    String description = tokens[6];
                    String releaseDate = tokens[7];
                    GameAddDTO gameAddDTO = new GameAddDTO(title, trailer, thumbnailURL, size, price, description, LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    if (this.validationUtil.isValid(gameAddDTO)) {
                        this.gameServices.addGame(gameAddDTO);
                        System.out.printf("Added %s%n", gameAddDTO.getTitle());
                    } else {
                        this.validationUtil.getViolations(gameAddDTO)
                                .stream().map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                    break;
                case "EditGame":
                    Long gameId = Long.parseLong(tokens[1]);
                    Game gameEdit = this.gameServices.getGameById(gameId);
                    for (int i = 2; i < tokens.length; i++) {
                        String[] elements = tokens[i].split("=");
                        switch (elements[0]) {
                            case "title":
                                gameEdit.setTitle(elements[1]);
                                break;
                            case "price":
                                gameEdit.setPrice(new BigDecimal(elements[1]));
                                break;
                            case "size":
                                gameEdit.setSize(Double.parseDouble(elements[1]));
                                break;
                            case "trailer":
                                gameEdit.setTrailer(elements[1]);
                                break;
                            case "thumbnailURL":
                                gameEdit.setImageThumbnail(elements[1]);
                                break;
                            case "description":
                                gameEdit.setDescription(elements[1]);
                                break;
                        }
                    }
                    //   this.gameServices.editGame(gameId,gameEdit);
                    break;
                case "DeleteGame":
                    this.gameServices.deleteGame(Long.parseLong(tokens[1]));
                    break;
                case "AllGames":
                    this.gameServices.allGames();
                    break;
                case "DetailGame":
                    this.gameServices.gameDetails(tokens[1]);
                    break;
                case "OwnedGames":
              //      this.userServices.userGames();
                    break;
                case "AddItem":
                    break;
                case "RemoveItem":
                    break;
                case "BuyItem":
                    break;
            }
            System.out.println("Please, enter command line (<Enter> for exit) : ");
            input = reader.readLine();
        }

        System.out.println();
        System.out.println("GOOD BYE ! See you soon :) ");
        System.out.println();
    }
}
