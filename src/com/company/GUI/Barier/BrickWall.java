package com.company.GUI.Barier;

import com.company.GUI.Tanks.CustomRectangle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BrickWall extends Barrier{
    public BrickWall(){
        this.color1 = new CustomRectangle(new Color(.41,.09,.07, 1),getPixel());
        this.color2 = new CustomRectangle(new Color(.61,.29,0, 1), getPixel());
        this.color3 = new CustomRectangle(new Color(.39,.38,.38, 1), getPixel());
    }
    @Override
    public GridPane getBarrier(){
        GridPane gridPane = new GridPane();
        
        return gridPane;
    }
}
