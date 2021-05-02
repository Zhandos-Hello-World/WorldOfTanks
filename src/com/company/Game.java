package com.company;
import com.company.offlineTwoPlayers.SecondPlayer;
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
    public void addPlayer(BotPlayer botPlayer){
        botPlayer.setMap(map);
    }
}

