package com.company.GUI.Barier;

import com.company.GUI.Tanks.CustomRectangle;
import com.company.GUI.Tanks.WhiteTank;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class SteelWall extends Barrier{
    public SteelWall(){
        this.color1 = new CustomRectangle(new Color(.48,.49,.48, 1),getPixel());
        this.color2 = new CustomRectangle(new Color(.74,.75,.74, 1), getPixel());
        this.color3 = new CustomRectangle(new Color(1,1,1, 1), getPixel());
    }
    GridPane gridPane1 = new GridPane();
    @Override
    public GridPane getBarrier() {
        gridPane1 = new GridPane();
        for(int i = 0; i < 16; i++){
            //horizontal
            gridPane1.add(color2.get(), i, 0);
        }
        WhiteSquare(1);
        for(int i = 0; i < 16; i++){
            //horizontal
            gridPane1.add(color2.get(), i, 8);
        }
        WhiteSquare(9);
        return gridPane1;
    }
    private void WhiteSquare(int x){
        for(int i = 0; i <= 15; i++){
            if(i == 7 || i == 15){
                gridPane1.add(color1.get(), i, x);
            }
            else{
                gridPane1.add(color2.get(), i, x);
            }
        }
        for(int j = x+1; j <= x + 4; j++){
            for(int i = 0; i <= 15; i++){
                if((i >= 2 && i <= 5) || (i >= 10 && i <= 13)){
                    gridPane1.add(color3.get(), i, j);
                }
                else if((i >= 6 && i <= 7) || (i >= 14)){
                    gridPane1.add(color1.get(), i, j);
                }
                else{
                    gridPane1.add(color2.get(), i, j);
                }
            }
        }
        for(int i = 0; i < 16; i++){
            if(i <= 1){
                gridPane1.add(color2.get(), i, x + 5);
            }
            else if((i >= 2 && i <= 7) || (i >= 10)){
                gridPane1.add(color1.get(), i, x + 5);
            }
            else{
                gridPane1.add(color2.get(), i, x+5);
            }
        }
        for(int i = 0; i < 16; i++){
            if(i == 0){
                gridPane1.add(color2.get(), i, x + 6);
            }
            else if((i >= 1 && i <= 7) || (i >= 9)){
                gridPane1.add(color1.get(), i, x + 6);
            }
            else{
                gridPane1.add(color2.get(), i, x+6);
            }
        }
    }
    @Override
    public boolean ableToDestroyed(){
        return false;
    }
}
