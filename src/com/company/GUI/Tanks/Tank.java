package com.company.GUI.Tanks;

import com.company.GUI.Settings;
import com.company.MyPlayer;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

abstract public class Tank extends MyPlayer implements Settings {
    protected Color mirrorColor = new Color(0,0,0, 1);
    protected Color originalColor = new Color(0,0,0, 1);
    protected Color shadowColor = new Color(0,0,0, 1);
    protected static Pane pane;
    protected CustomRectangle mirror;
    protected CustomRectangle original;
    protected CustomRectangle shadow;
    protected CustomRectangle black = new CustomRectangle(new Color(0,0,0,1), getPixel());
    private double rotate;
    public GridPane caterpillarLeft(){
        GridPane caterpillarLeft = new GridPane();
        caterpillarLeft.setStyle("-fx-background-color: black; -fx-color-label-visible: true");
        for(int i = 0; i <= 4; i++){
            for(int j = 0; j < 3; j++){
                caterpillarLeft.add(black.get(), j, i);
            }
        }
        caterpillarLeft.add(mirror.get(), 0, 5);
        caterpillarLeft.add(original.get(), 1,5);
        caterpillarLeft.add(original.get(), 2,5);

        for(int i = 6; i < getSizeHeight(); i++){
            if(i <= 10){
                if(!(i % 2 == 0)){
                    caterpillarLeft.add(mirror.get(), 0, i);
                    caterpillarLeft.add(original.get(), 1, i);
                    caterpillarLeft.add(mirror.get(), 2, i);
                }
                else{
                    caterpillarLeft.add(shadow.get(), 0, i);
                    caterpillarLeft.add(shadow.get(), 1, i);
                    caterpillarLeft.add(mirror.get(), 2, i);
                }
            }
            else{
                if(i % 2 == 0){
                    caterpillarLeft.add(mirror.get(), 0, i);
                    caterpillarLeft.add(original.get(), 1, i);
                    caterpillarLeft.add(mirror.get(), 2, i);
                }
                else{
                    caterpillarLeft.add(shadow.get(), 0, i);
                    caterpillarLeft.add(shadow.get(), 1, i);
                    caterpillarLeft.add(mirror.get(), 2, i);
                }
            }
        }
        caterpillarLeft.add(mirror.get(), 0, getSizeHeight());
        caterpillarLeft.add(original.get(), 1, getSizeHeight());
        caterpillarLeft.add(original.get(), 2, getSizeHeight());
        return caterpillarLeft;
    }
    public GridPane caterpillarRight() {
        GridPane caterpillarRight = new GridPane();
        caterpillarRight.setStyle("-fx-background-color: black; -fx-color-label-visible: true");
        for(int i = 0; i <= 4; i++){
            for(int j = 0; j < 3; j++){
                caterpillarRight.add(black.get(), j, i);
            }
        }
        caterpillarRight.add(mirror.get(), 0, 5);
        caterpillarRight.add(original.get(), 1,5);
        caterpillarRight.add(original.get(), 2,5);

        for(int i = 6; i < 17; i++){
            if(i <= 10){
                if(i % 2 == 0){
                    for(int j = 0; j < 3; j++){
                        caterpillarRight.add(shadow.get(), j, i);
                    }
                }
                else{
                    caterpillarRight.add(shadow.get(), 0, i);
                    caterpillarRight.add(original.get(), 1, i);
                    caterpillarRight.add(original.get(), 2, i);
                }
            }
            else{
                if(i % 2 != 0){
                    for(int j = 0; j < 3; j++){
                        caterpillarRight.add(shadow.get(), j, i);
                    }
                }
                else{
                    caterpillarRight.add(shadow.get(), 0, i);
                    caterpillarRight.add(original.get(), 1, i);
                    caterpillarRight.add(original.get(), 2, i);
                }
            }
        }
        return caterpillarRight;
    }
    public GridPane town() {
        GridPane townOfTheTank = new GridPane();
        townOfTheTank.setStyle("-fx-background-color: black; -fx-color-label-visible: true");
        for(int i = 0; i < 7; i++){
            for(int j = 0; j <= 6; j++){
                if(j == 3 && i > 2){
                    townOfTheTank.add(mirror.get(), j, i);
                }
                else{
                    townOfTheTank.add(black.get(), j, i);
                }
            }
        }
        townOfTheTank.add(black.get(), 0,7);
        townOfTheTank.add(mirror.get(), 1, 7);
        townOfTheTank.add(original.get(), 2, 7);
        townOfTheTank.add(mirror.get(), 3,7);
        townOfTheTank.add(shadow.get(), 4, 7);
        townOfTheTank.add(shadow.get(), 5, 7);

        townOfTheTank.add(mirror.get(), 0, 8);
        townOfTheTank.add(mirror.get(), 1, 8);
        townOfTheTank.add(original.get(), 2, 8);
        townOfTheTank.add(original.get(), 3,8);
        townOfTheTank.add(original.get(), 4, 8);
        townOfTheTank.add(original.get(), 5, 8);
        townOfTheTank.add(shadow.get(), 6,8);

        townOfTheTank.add(mirror.get(), 0, 9);
        townOfTheTank.add(original.get(), 1, 9);
        townOfTheTank.add(mirror.get(), 2, 9);
        townOfTheTank.add(mirror.get(), 3,9);
        townOfTheTank.add(original.get(), 4, 9);
        townOfTheTank.add(original.get(), 5, 9);
        townOfTheTank.add(original.get(), 6,9);

        townOfTheTank.add(mirror.get(), 0, 10);
        townOfTheTank.add(original.get(), 1, 10);
        townOfTheTank.add(mirror.get(), 2, 10);
        townOfTheTank.add(mirror.get(), 3,10);
        townOfTheTank.add(original.get(), 4, 10);
        townOfTheTank.add(original.get(), 5, 10);
        townOfTheTank.add(original.get(), 6,10);

        townOfTheTank.add(mirror.get(), 0, 11);
        townOfTheTank.add(original.get(), 1, 11);
        townOfTheTank.add(mirror.get(), 2, 11);
        townOfTheTank.add(original.get(), 3,11);
        townOfTheTank.add(shadow.get(), 4, 11);
        townOfTheTank.add(original.get(), 5, 11);
        townOfTheTank.add(original.get(), 6,11);

        townOfTheTank.add(mirror.get(), 0, 12);
        townOfTheTank.add(original.get(), 1, 12);
        townOfTheTank.add(mirror.get(), 2, 12);
        townOfTheTank.add(original.get(), 3,12);
        //shadow - original 3 2
        townOfTheTank.add(shadow.get(), 4, 12);
        townOfTheTank.add(original.get(), 5, 12);
        townOfTheTank.add(original.get(), 6,12);

        townOfTheTank.add(mirror.get(), 0, 13);
        townOfTheTank.add(mirror.get(), 1, 13);
        townOfTheTank.add(original.get(), 2, 13);
        townOfTheTank.add(shadow.get(), 3,13);
        townOfTheTank.add(shadow.get(), 4, 13);
        townOfTheTank.add(original.get(), 5, 13);
        townOfTheTank.add(original.get(), 6,13);

        townOfTheTank.add(shadow.get(), 0, 14);
        townOfTheTank.add(mirror.get(), 1, 14);
        townOfTheTank.add(mirror.get(), 2, 14);
        townOfTheTank.add(original.get(), 3,14);
        townOfTheTank.add(original.get(), 4, 14);
        townOfTheTank.add(original.get(), 5, 14);
        townOfTheTank.add(shadow.get(), 6,14);

        townOfTheTank.add(black.get(), 0, 15);
        townOfTheTank.add(shadow.get(), 1, 15);
        townOfTheTank.add(shadow.get(), 2, 15);
        townOfTheTank.add(shadow.get(), 3,15);
        townOfTheTank.add(shadow.get(), 4, 15);
        townOfTheTank.add(shadow.get(), 5, 15);
        townOfTheTank.add(black.get(), 6,15);
        return townOfTheTank;
    }
    public GridPane left(){
        GridPane gp = new GridPane();
        for(int i = 0; i < getSizeHeight(); i++){
            for(int j = 0; j < 1; j++){
                gp.add(black.get(), j, i);
            }
        }
        return gp;
    }
    public Pane initializeOnTank() {
        pane = new Pane();
        HBox hbox = new HBox();
        hbox.getChildren().addAll(left(), caterpillarLeft(), town(), caterpillarRight());
        pane.getChildren().add(hbox);
        return pane;
    }
    public void moveRight(){
        pane.setRotate(90);
    }
    public void moveLeft(){
        pane.setRotate(-90);
    }
    public void moveUp(){
        pane.setRotate(0);
    }
    public void moveDown(){
        pane.setRotate(180);
    }
}
