package com.example.spring_data_auto_maping.services.impls;

import com.example.spring_data_auto_maping.domains.DTOs.AllGamesDTO;
import com.example.spring_data_auto_maping.domains.DTOs.GameAddDTO;
import com.example.spring_data_auto_maping.domains.DTOs.GameDetailsDTO;
import com.example.spring_data_auto_maping.domains.DTOs.GameEditDTO;
import com.example.spring_data_auto_maping.domains.entities.Game;
import com.example.spring_data_auto_maping.repositories.GameRepository;
import com.example.spring_data_auto_maping.services.GameServices;
import com.example.spring_data_auto_maping.services.UserServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GameServicesImpl implements GameServices {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final UserServices userServices;

    @Autowired
    public GameServicesImpl(GameRepository gameRepository, ModelMapper modelMapper, UserServices userServices) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.userServices = userServices;
    }

    @Override
    public void addGame(GameAddDTO gameAddDTO) {
        Game game = this.modelMapper.map(gameAddDTO, Game.class);
        if (!userServices.isLoggedUserIsAdmin()) {
            System.out.println("Logged user is not Admin!");
            return;
        }
        this.gameRepository.saveAndFlush(game);
    }

    @Override
    public void deleteGame(Long id) {
        if (!userServices.isLoggedUserIsAdmin()) {
            System.out.println("Logged user is not Admin!");
            return;
        }
        if (id < 1 || id > this.gameRepository.count()) {
            System.out.println("Invalid Id");
            return;
        }
        Game game = getGame(id);
        String gameName = game.getTitle();
        this.gameRepository.deleteById(id);
        System.out.printf("Deleted %s%n", gameName);
    }

    @Override
    public void editGame(Long id, GameEditDTO gameEditDTO) {
      //  S s = this.gameRepository.saveAndFlush(gameEditDTO);
    }

    @Override
    public Game getGameById(Long Id) {
        return this.gameRepository.getOne(Id);
    }

    @Override
    public void allGames() {
        List<AllGamesDTO> allGamesDTOList=new ArrayList<>();
        this.gameRepository.findAll().forEach(ag->{
         allGamesDTOList.add(this.modelMapper.map(ag, AllGamesDTO.class));
        });
        allGamesDTOList.forEach(g->System.out.printf("%s %s%n",g.getTitle(),g.getPrice()));

    }

    @Override
    public void gameDetails(String title) {
        GameDetailsDTO game=this.modelMapper.map(this.gameRepository.findByTitle(title),GameDetailsDTO.class);
        if (game==null){
            System.out.println("Invalid game title");
        }
        System.out.printf("Title: %s%n",game.getTitle());
        System.out.printf("Price: %.2f%n",game.getPrice());
        System.out.printf("Description: %s%n",game.getDescription());
        System.out.printf("Release date: %s%n", game.getReleaseDate());
    }

    private Game getGame(Long id) {
        return this.gameRepository.getOne(id);
    }
}
