package com.company;
import javafx.scene.layout.Pane;

public interface Player {
    void setMap(Map map);
    void moveRight();
    void moveLeft();
    void moveUp();
    void moveDown();
    Position getPosition();
    Pane initializeOnTank();
    void fire();
}
