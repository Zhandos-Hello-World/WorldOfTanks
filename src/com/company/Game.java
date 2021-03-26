package com.company;
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
}

