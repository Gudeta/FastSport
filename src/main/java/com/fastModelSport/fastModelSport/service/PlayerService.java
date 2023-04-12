package com.fastModelSport.fastModelSport.service;

import com.fastModelSport.fastModelSport.model.Player;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.List;

@Service
public class PlayerService {
    public List<Player> getPlayersWithFastStats() {
        List<Player> players = readPlayersFromJsonFile();
        for (Player player : players) {
            int fastStat = Util.calculateFastStat(player);
            player.setFastStat(fastStat);
        }
        players.sort(Comparator.comparingInt(Player::getFastStat).reversed());
        return players;
    }

    private List<Player> readPlayersFromJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
        TypeReference<List<Player>> typeReference = new TypeReference<>() {
        };
        InputStream inputStream;
        try {
            //Read from my sample json file
            inputStream = new ClassPathResource("sample.json").getInputStream();
            return objectMapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Facing error reading in JSON file", e);
        }
    }

}
