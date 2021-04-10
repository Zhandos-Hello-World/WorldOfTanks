package com.company.GUI.Barier;

import com.company.GUI.Tanks.CustomRectangle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class SteelWall extends Barrier{
    public SteelWall(){
        this.color1 = new CustomRectangle(new Color(.48,.49,.48, 1),getPixel());
        this.color2 = new CustomRectangle(new Color(.74,.75,.74, 1), getPixel());
        this.color3 = new CustomRectangle(new Color(1,1,1, 1), getPixel());
    }
    @Override
    public GridPane getBarrier() {
        GridPane gridPane1 = new GridPane();
        return gridPane1;
    }
    @Override
    public boolean ableToDestroyed(){
        return false;
    }
}
