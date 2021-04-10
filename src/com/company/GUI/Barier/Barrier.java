package com.company.GUI.Barier;

import com.company.GUI.Settings;
import com.company.GUI.Tanks.CustomRectangle;
import javafx.scene.layout.GridPane;

abstract public class Barrier implements Settings {
    protected CustomRectangle color1;
    protected CustomRectangle color2;
    protected CustomRectangle color3;
    protected boolean destroyed = false;
    private int x, y;

    abstract public GridPane getBarrier();
    //I am going to write logic barrier which is destroyed by fire of the tank
    abstract public boolean ableToDestroyed();
    public void setYX(int y, int x){
        this.y = y;
        this.x = x;
    }
    public void setX(int setX){
        this.x = x;
    }
    public void setY(int setY){
        this.y = y;
    }
    public int getX(){
        return y;
    }
    public int getY(){
        return x;
    }
    public boolean disAppear(){
        destroyed = true;
        return ableToDestroyed();
    }
}
