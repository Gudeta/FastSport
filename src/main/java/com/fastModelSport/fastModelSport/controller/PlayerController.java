package com.fastModelSport.fastModelSport.controller;

import com.fastModelSport.fastModelSport.model.Player;
import com.fastModelSport.fastModelSport.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/faststat")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> getFastStats() {
        List<Player> players = playerService.getPlayersWithFastStats();
        return ResponseEntity.ok(players);
    }
}
