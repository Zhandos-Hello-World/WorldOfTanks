package com.company;

public interface Player {
    void setMap(Map map);
    void moveRight();
    void moveLeft();
    void moveUp();
    void moveDown();
    Position getPostition();
}
