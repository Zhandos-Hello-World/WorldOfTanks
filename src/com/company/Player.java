package com.company;

import javafx.scene.Node;

public interface Player {
    void setMap(Map map);
    void moveRight();
    void moveLeft();
    void moveUp();
    void moveDown();
    Position getPosition();
    public Node initializeOnTank();
}
