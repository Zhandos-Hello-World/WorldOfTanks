package com.company.GUI.Barier;

import com.company.GUI.Tanks.CustomRectangle;
import com.company.GUI.Tanks.Tank;
import com.company.GUI.Tanks.WhiteTank;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Barrier {
    private CustomRectangle red;
    private CustomRectangle orange;
    private CustomRectangle gray;
    private int pixel;
    public Barrier(){
        Tank tank = new WhiteTank();
        this.pixel = tank.getPixel();
        this.red = new CustomRectangle(new Color(.41,.09,.07, 1),pixel);
        this.orange = new CustomRectangle(new Color(.61,.29,0, 1), pixel);
        this.gray = new CustomRectangle(new Color(.39,.38,.38, 1), pixel);
    }
    public GridPane BarrierInstanceRed(){
        GridPane gridPane = new GridPane();
        gridPane.add(orange.get(), 0, 0);
        gridPane.add(orange.get(), 1, 0);
        gridPane.add(orange.get(), 2, 0);
        gridPane.add(orange.get(), 3, 0);
        gridPane.add(orange.get(), 4, 0);
        gridPane.add(orange.get(), 5, 0);
        gridPane.add(orange.get(), 6, 0);

        gridPane.add(gray.get(), 7, 0);
        gridPane.add(orange.get(), 8, 0);
        gridPane.add(orange.get(), 9, 0);
        gridPane.add(orange.get(), 10, 0);
        gridPane.add(orange.get(), 11, 0);
        gridPane.add(orange.get(), 12, 0);
        gridPane.add(orange.get(), 13, 0);

        gridPane.add(red.get(), 0, 1);
        gridPane.add(red.get(), 1, 1);
        gridPane.add(red.get(), 2, 1);
        gridPane.add(red.get(), 3, 1);
        gridPane.add(red.get(), 4, 1);
        gridPane.add(red.get(), 5, 1);
        gridPane.add(red.get(), 6, 1);

        for(int i = 0; i < 14; i++){
            for(int j = 0; j < 13; j++){
                if(i < 4){
                    if(j == 7){
                        gridPane.add(gray.get(), j, i);
                    }
                    else{
                        if(i == 0){
                            gridPane.add(orange.get(), j, i);
                        }
                        else if(i < 3){
                            gridPane.add(red.get(), j, i);
                        }
                        else{
                            gridPane.add(gray.get(), j, i);
                        }
                    }
                }
                else if(i < 9){
                    if(j == 3){
                        gridPane.add(gray.get(), j, i);
                    }
                    else{
                        if(i == 4){
                            gridPane.add(orange.get(), j, i);
                        }
                        else if(i < 8){
                            gridPane.add(red.get(), j, i);
                        }
                        else{
                            gridPane.add(gray.get(), j, i);
                        }
                    }
                }
                else{
                    if(j == 6){
                        gridPane.add(gray.get(), j, i);
                    }
                    else{
                        if(i == 9){
                            gridPane.add(orange.get(), j, i);
                        }
                        else if(i < 13){
                            gridPane.add(red.get(), j, i);
                        }
                        else{
                            gridPane.add(gray.get(), j, i);
                        }
                    }
                }
            }
        }

        return gridPane;
    }

}
