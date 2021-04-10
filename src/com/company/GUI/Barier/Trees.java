package com.company.GUI.Barier;

import com.company.GUI.Tanks.CustomRectangle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Trees extends Barrier{
    public Trees(){
        this.color1 = new CustomRectangle(new Color(.19,.38,.26, 1), getPixel());
        this.color2 = new CustomRectangle(new Color(.61,.92,0, 1), getPixel());
        this.color3 = new CustomRectangle(new Color(.22,.41,0, 1), getPixel());
    }

    @Override
    public GridPane getBarrier() {
        GridPane gp = new GridPane();
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                boolean check = true;
                int []except = {0, 7, 8, 15};
                if(i == 0 && j == 0){
                    check = false;
                }
                else if((i == 7 || i == 8) && (j == 0 || j == 15)){
                    check =false;
                }
                else if((j == 7 || j == 8) && (i == 0 || i == 15)){
                    check =false;
                }
                else if(i == 15 && j == 15){
                    check = false;
                }
                else if(i == 15 && j == 0){
                    check = false;
                }
                else if(i == 0 && j == 15){
                    check = false;
                }
                else if((i == 7 || i == 8) && (j == 7 || j == 8)){
                    check = false;
                }
                if (check) {
                    int x = (int)(Math.random() * 3 + 1);
                    if(x != 3){
                        x = (int)(Math.random() * 3 + 1);
                    }
                    if(x == 1){
                        gp.add(color1.get(), j, i);
                    }
                    else if(x == 2){
                        gp.add(color3.get(), j, i);
                    }
                    else{
                        gp.add(color2.get(), j, i);
                    }
                }
                else{
                    gp.add(new Rectangle(getPixel(), getPixel(),new Color(0,0,0,1)), j, i);
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

