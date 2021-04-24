package com.company;

import com.company.offlineTwoPlayers.SecondPlayer;

import java.util.ArrayList;

public class Game{
    private Map map;
    public Game(Map map){
        this.map = map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    public void addPlayer(Player player){
        player.setMap(map);
    }
    public void addPlayer(SecondPlayer secondPlayer){
        secondPlayer.setMap(map);
    }
}

