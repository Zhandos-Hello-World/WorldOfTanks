package com.company.GUI.Barier;

import com.company.GUI.Tanks.CustomRectangle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Null extends Barrier{
    public Null(){
        this.color1 = new CustomRectangle(new Color(0, 0,0 ,1), getPixel());
    }
    public GridPane getBarrier(){
        GridPane gridPane = new GridPane();
        for(int i = 0; i < getSizeHeight(); i ++){
            for(int j = 0; j < getSizeWidth(); j++){
                gridPane.add(color1.get(), j, i);
            }
        }
        return gridPane;
    }
    public boolean ableToDestroyed(){
        return false;
    }
}
