package com.company.GUI.Bullet;

import com.company.GUI.Tanks.CustomRectangle;
import com.company.GUI.Tanks.Tank;
import com.company.GUI.Tanks.WhiteTank;
import com.company.InvalidMapException;
import com.company.Map;
import com.company.Position;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Bullet {
    CustomRectangle black;
    CustomRectangle colorOfTheBullet;
    int pixel;
    private Position positionOfTheBullet;
    private static boolean check = false;
    public Bullet(){
        //for get pixel
        Tank tank = new WhiteTank();
        this.pixel = tank.getPixel();
        black = new CustomRectangle(new Color(0,0,0,1), pixel);
        colorOfTheBullet = new CustomRectangle(new Color(.68,.68,.68, 1), pixel);
    }
    public boolean checkBarrier(Map map, int rotate, Position position) throws InvalidMapException {
        this.positionOfTheBullet = position;
        if(rotate == 0){
            for(int i = positionOfTheBullet.getX(); i < map.getSize(); i++){
                if(map.getValueAt(positionOfTheBullet.getY(), i) == 'B'){
                    positionOfTheBullet = new Position(i, positionOfTheBullet.getY());
                    check = true;
                    break;
                }
                else if(map.getValueAt(positionOfTheBullet.getY(), i) == 'S'){
                    check = false;
                    break;
                }
            }
        }
        else if(rotate == 1){
            for(int i = positionOfTheBullet.getX(); i >= 0; i--){
                if(map.getValueAt(positionOfTheBullet.getY(), i) == 'B'){
                    positionOfTheBullet = new Position(i, positionOfTheBullet.getY());
                    check = true;
                    break;
                }
                else if(map.getValueAt(positionOfTheBullet.getY(), i) == 'S'){
                    check = false;
                    break;
                }
            }
        }
        else if(rotate == 2){
            for(int i = positionOfTheBullet.getY(); i >= 0; i--){
                if(map.getValueAt(i, positionOfTheBullet.getX()) == 'B'){
                    positionOfTheBullet = new Position(positionOfTheBullet.getX(), i);
                    check = true;
                    break;
                }
                else if(map.getValueAt(i, positionOfTheBullet.getX()) == 'S'){
                    check = false;
                    break;
                }
            }

        }
        else if(rotate == 3){
            for(int i = positionOfTheBullet.getY(); i < map.getSize(); i++){
                if(map.getValueAt(i, positionOfTheBullet.getX()) == 'B'){
                    positionOfTheBullet = new Position(positionOfTheBullet.getX(), i);
                    check = true;
                    break;
                }
                else if(map.getValueAt(i, positionOfTheBullet.getX()) == 'S'){
                    check = false;
                    break;
                }
            }
        }
        else{
            check = false;
        }
        return check;
    }
    public Position getDelete(Map map, int rotate, Position position) throws InvalidMapException {
        if(!checkBarrier(map, rotate, position)){
            throw new InvalidMapException();
        }
        else{

            check = false;
            return positionOfTheBullet;
        }
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
