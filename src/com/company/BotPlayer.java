package com.company;

import com.company.GUI.Tanks.Tank;
import javafx.scene.layout.Pane;

public class BotPlayer extends Tank implements Player{
    private Map map;
    BotPlayer(){

    }

    @Override
    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveUp() {

    }

    @Override
    public void moveDown() {

    }

    @Override
    public Position getPosition() {
        return null;
    }

    @Override
    public Pane initializeOnTank() {
        return null;
    }

    @Override
    public void fire() {

    }
}
