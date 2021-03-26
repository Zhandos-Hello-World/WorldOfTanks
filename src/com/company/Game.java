package com.company;

public class Game{
    private Map map;
    private Player player;

    public Game(Map map) throws InvalidMapException{
        this.map = map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    public void addPlayer(Player player){
        this.player = player;
    }
}
