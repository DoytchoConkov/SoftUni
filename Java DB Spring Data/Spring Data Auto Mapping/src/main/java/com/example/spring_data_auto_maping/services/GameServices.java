package com.example.spring_data_auto_maping.services;

import com.example.spring_data_auto_maping.domains.DTOs.GameAddDTO;
import com.example.spring_data_auto_maping.domains.DTOs.GameEditDTO;
import com.example.spring_data_auto_maping.domains.entities.Game;

public interface GameServices {

    void addGame(GameAddDTO gameAddDTO);
    void deleteGame(Long id);
    void editGame(Long id, GameEditDTO gameAddDTO);
    Game getGameById(Long Id);
    void allGames();
    void gameDetails(String title);
}
