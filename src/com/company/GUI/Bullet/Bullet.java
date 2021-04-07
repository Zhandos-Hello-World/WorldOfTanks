package com.company.GUI.Bullet;

import com.company.GUI.Tanks.CustomRectangle;
import com.company.GUI.Tanks.Tank;
import com.company.GUI.Tanks.WhiteTank;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Bullet {
    CustomRectangle black;
    CustomRectangle colorOfTheBullet;
    int pixel;
    public Bullet(){
        //for get pixel
        Tank tank = new WhiteTank();
        this.pixel = tank.getPixel();
        black = new CustomRectangle(new Color(0,0,0,1), pixel);
        colorOfTheBullet = new CustomRectangle(new Color(.68,.68,.68, 1), pixel);
    }
    public GridPane initializeOnBullet(){
        GridPane bullet = new GridPane();
        for(int i = 0; i < 14; i++){
            for(int j = 0; j < 13; j++){
                if(i < 3){
                    if(j == 7){
                        bullet.add(colorOfTheBullet.get(), j, i);
                    }
                    else{
                        bullet.add(black.get(), j, i);
                    }
                }
                else if(i >= 3 && i <= 9){
                    if(j >= 6 && j <= 8){
                        bullet.add(colorOfTheBullet.get(), j, i);
                    }
                    else{
                        bullet.add(black.get(), j, i);
                    }
                }
                else{
                    bullet.add(black.get(), j, i);
                }
            }
        }
        return bullet;
    }
}
