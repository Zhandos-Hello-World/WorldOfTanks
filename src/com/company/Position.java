package com.company;


public class Position{
    private int x, y;
    Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Position position) {
        return getX() == position.getX() && getY() == position.getY();
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }

}