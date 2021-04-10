package com.company.GUI.Barier;

import com.company.GUI.Tanks.CustomRectangle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BrickWall extends Barrier{
    private boolean destroyed = false;
    public BrickWall(){
        this.color1 = new CustomRectangle(new Color(.41,.09,.07, 1),getPixel());
        this.color2 = new CustomRectangle(new Color(.61,.29,0, 1), getPixel());
        this.color3 = new CustomRectangle(new Color(.39,.38,.38, 1), getPixel());
    }
    @Override
    public GridPane getBarrier(){
        GridPane gridPane = new GridPane();
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                gridPane.add(color1.get(), j, i);
            }
        }
        return gridPane;
    }
    @Override
    public boolean ableToDestroyed(){
        return true;
    }


}
