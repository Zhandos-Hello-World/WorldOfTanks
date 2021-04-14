package com.company.GUI.Barier;

import com.company.GUI.Tanks.CustomRectangle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Water extends Barrier{
    public Water(){
        this.color1 = new CustomRectangle(new Color(.26,.25,1, 1), getPixel());
        this.color2 = new CustomRectangle(new Color(.74,.75,.74, 1), getPixel());
        this.color3 = new CustomRectangle(new Color(.65,1,.97, 1), getPixel());
    }

    @Override
    public GridPane getBarrier(){
        GridPane gp = new GridPane();
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                    int x = (int)(Math.random() * 3 + 1);
                    if(x != 3){
                        x = (int)(Math.random() * 3 + 1);
                    }
                    if(x == 1){
                        gp.add(color2.get(), j, i);
                    }
                    else if(x == 2){
                        gp.add(color3.get(), j, i);
                    }
                    else{
                        gp.add(color1.get(), j, i);
                    }
                }
        }
        return gp;
    }
    @Override
    public boolean ableToDestroyed(){
        return false;
    }
}
