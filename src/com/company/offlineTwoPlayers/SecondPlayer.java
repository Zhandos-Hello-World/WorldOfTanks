package com.company.offlineTwoPlayers;

import com.company.GUI.Bullet.Bullet;
import com.company.GUI.Settings;
import com.company.GUI.Tanks.CustomRectangle;
import com.company.InvalidMapException;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class SecondPlayer extends AnotherPlayers implements Settings {
    protected Color mirrorColor;
    protected Color originalColor;
    protected Color shadowColor;
    protected static Pane pane;
    protected CustomRectangle mirror;
    protected CustomRectangle original;
    protected CustomRectangle shadow;
    protected static Bullet bullet = new Bullet('P');
    protected CustomRectangle black = new CustomRectangle(new Color(0, 0, 0, 1), getPixel());
    private static boolean canR, canL, canU = true, canD;
    public SecondPlayer(){
        this.mirrorColor = new Color(1,1,1, 1);
        this.originalColor = new Color(.71,.19,.13, 1);
        this.shadowColor = new Color(.35,0,.48, 1);
        this.mirror = new CustomRectangle(this.mirrorColor, getPixel());
        this.original = new CustomRectangle(this.originalColor, getPixel());
        this.shadow = new CustomRectangle(this.shadowColor, getPixel());
    }
    public void setColor(int i){
        Color [][]colors = {{new Color(.91, .91, .58, 1), new Color(.91, .61, .13, 1), new Color(.42, .42, 0, 1)},
                {new Color(1, 1, 1, 1), new Color(.71, .19, .13, 1), new Color(.35, 0, .48, 1)},
                {new Color(.71,.97,.81, 1), new Color(0,.55,.19, 1), new Color(0,.32,0, 1)},
                {new Color(1,1,1, 1), new Color(.42,.42,.42, 1), new Color(0,.17,.20, 1)}};
        this.mirrorColor = colors[i][0];
        this.originalColor = colors[i][1];
        this.shadowColor = colors[i][2];
        this.mirror = new CustomRectangle(this.mirrorColor, getPixel());
        this.original = new CustomRectangle(this.originalColor, getPixel());
        this.shadow = new CustomRectangle(this.shadowColor, getPixel());
    }


    public GridPane caterpillarLeft() {
        GridPane caterpillarLeft = new GridPane();
        caterpillarLeft.setStyle("-fx-background-color: black; -fx-color-label-visible: true");

        caterpillarLeft.setPadding(new Insets(0, 0, 0, 0));

        CustomRectangle black = new CustomRectangle(new Color(0, 0, 0, 1), getPixel());
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j < 3; j++) {
                caterpillarLeft.add(black.get(), j, i);
            }
        }

        caterpillarLeft.add(mirror.get(), 0, 2);
        caterpillarLeft.add(original.get(), 1, 2);
        caterpillarLeft.add(original.get(), 2, 2);

        for (int i = 3; i < 13; i++) {
            if (i <= 7) {
                if (i % 2 == 0) {
                    caterpillarLeft.add(mirror.get(), 0, i);
                    caterpillarLeft.add(original.get(), 1, i);
                    caterpillarLeft.add(mirror.get(), 2, i);
                } else {
                    caterpillarLeft.add(shadow.get(), 0, i);
                    caterpillarLeft.add(shadow.get(), 1, i);
                    caterpillarLeft.add(mirror.get(), 2, i);
                }
            } else {
                if (i % 2 != 0) {
                    caterpillarLeft.add(mirror.get(), 0, i);
                    caterpillarLeft.add(original.get(), 1, i);
                    caterpillarLeft.add(mirror.get(), 2, i);
                } else {
                    caterpillarLeft.add(shadow.get(), 0, i);
                    caterpillarLeft.add(shadow.get(), 1, i);
                    caterpillarLeft.add(mirror.get(), 2, i);
                }
            }
        }
        caterpillarLeft.add(mirror.get(), 0, 13);
        caterpillarLeft.add(original.get(), 1, 13);
        caterpillarLeft.add(original.get(), 2, 13);
        return caterpillarLeft;
    }
    public GridPane caterpillarRight() {
        GridPane caterpillarRight = new GridPane();
        caterpillarRight.setStyle("-fx-background-color: black; -fx-color-label-visible: true");
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j < 3; j++) {
                caterpillarRight.add(black.get(), j, i);
            }
        }
        caterpillarRight.add(mirror.get(), 0, 2);
        caterpillarRight.add(original.get(), 1, 2);
        caterpillarRight.add(original.get(), 2, 2);

        for (int i = 3; i < 14; i++) {
            if (i <= 7) {
                if (i % 2 != 0) {
                    for (int j = 0; j < 3; j++) {
                        caterpillarRight.add(shadow.get(), j, i);
                    }
                } else {
                    caterpillarRight.add(shadow.get(), 0, i);
                    caterpillarRight.add(original.get(), 1, i);
                    caterpillarRight.add(original.get(), 2, i);
                }
            } else {
                if (i % 2 == 0) {
                    for (int j = 0; j < 3; j++) {
                        caterpillarRight.add(shadow.get(), j, i);
                    }
                } else {
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
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= 6; j++) {
                if (j == 3) {
                    townOfTheTank.add(mirror.get(), j, i);
                } else {
                    townOfTheTank.add(black.get(), j, i);
                }
            }
        }
        townOfTheTank.add(black.get(), 0, 4);
        townOfTheTank.add(mirror.get(), 1, 4);
        townOfTheTank.add(original.get(), 2, 4);
        townOfTheTank.add(mirror.get(), 3, 4);
        townOfTheTank.add(shadow.get(), 4, 4);
        townOfTheTank.add(shadow.get(), 5, 4);

        townOfTheTank.add(mirror.get(), 0, 5);
        townOfTheTank.add(mirror.get(), 1, 5);
        townOfTheTank.add(original.get(), 2, 5);
        townOfTheTank.add(original.get(), 3, 5);
        townOfTheTank.add(original.get(), 4, 5);
        townOfTheTank.add(original.get(), 5, 5);
        townOfTheTank.add(shadow.get(), 6, 5);

        townOfTheTank.add(mirror.get(), 0, 6);
        townOfTheTank.add(original.get(), 1, 6);
        townOfTheTank.add(mirror.get(), 2, 6);
        townOfTheTank.add(mirror.get(), 3, 6);
        townOfTheTank.add(original.get(), 4, 6);
        townOfTheTank.add(original.get(), 5, 6);
        townOfTheTank.add(original.get(), 6, 6);

        townOfTheTank.add(mirror.get(), 0, 7);
        townOfTheTank.add(original.get(), 1, 7);
        townOfTheTank.add(mirror.get(), 2, 7);
        townOfTheTank.add(mirror.get(), 3, 7);
        townOfTheTank.add(original.get(), 4, 7);
        townOfTheTank.add(original.get(), 5, 7);
        townOfTheTank.add(original.get(), 6, 7);

        townOfTheTank.add(mirror.get(), 0, 8);
        townOfTheTank.add(original.get(), 1, 8);
        townOfTheTank.add(mirror.get(), 2, 8);
        townOfTheTank.add(original.get(), 3, 8);
        townOfTheTank.add(shadow.get(), 4, 8);
        townOfTheTank.add(original.get(), 5, 8);
        townOfTheTank.add(original.get(), 6, 8);

        townOfTheTank.add(mirror.get(), 0, 9);
        townOfTheTank.add(original.get(), 1, 9);
        townOfTheTank.add(mirror.get(), 2, 9);
        townOfTheTank.add(original.get(), 3, 9);
        //shadow - original 3 2
        townOfTheTank.add(shadow.get(), 4, 9);
        townOfTheTank.add(original.get(), 5, 9);
        townOfTheTank.add(original.get(), 6, 9);

        townOfTheTank.add(mirror.get(), 0, 10);
        townOfTheTank.add(mirror.get(), 1, 10);
        townOfTheTank.add(original.get(), 2, 10);
        townOfTheTank.add(shadow.get(), 3, 10);
        townOfTheTank.add(shadow.get(), 4, 10);
        townOfTheTank.add(original.get(), 5, 10);
        townOfTheTank.add(original.get(), 6, 10);

        townOfTheTank.add(shadow.get(), 0, 11);
        townOfTheTank.add(mirror.get(), 1, 11);
        townOfTheTank.add(mirror.get(), 2, 11);
        townOfTheTank.add(original.get(), 3, 11);
        townOfTheTank.add(original.get(), 4, 11);
        townOfTheTank.add(original.get(), 5, 11);
        townOfTheTank.add(shadow.get(), 6, 11);

        townOfTheTank.add(black.get(), 0, 12);
        townOfTheTank.add(shadow.get(), 1, 12);
        townOfTheTank.add(shadow.get(), 2, 12);
        townOfTheTank.add(shadow.get(), 3, 12);
        townOfTheTank.add(shadow.get(), 4, 12);
        townOfTheTank.add(shadow.get(), 5, 12);
        townOfTheTank.add(black.get(), 6, 12);
        return townOfTheTank;
    }
    public Pane initializeOnTank() {
        HBox left = new HBox();
        GridPane gp = new GridPane();
        for(int i = 0; i < 1; i++) {
            for(int j = 0; j < 13; j++){
                gp.add(black.get(), i, j);
            }
        }
        left.getChildren().add(gp);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(left, caterpillarLeft(), town(), caterpillarRight());
        pane = new Pane();
        pane.getChildren().add(hbox);
        if(canU){
            pane.setRotate(0);
        }
        else if(canR){
            pane.setRotate(90);
        }
        else if(canL){
            pane.setRotate(-90);
        }
        else{
            pane.setRotate(-180);
        }
        return pane;
    }

    private void cannotRLUD() {
        canD = false;
        canR = false;
        canL = false;
        canU = false;
    }
    public void moveRight() {
        if (canR) {
            super.moveRight();
        } else {
            pane.setRotate(90);
            cannotRLUD();
            canR = true;
        }
    }

    public void moveLeft() {
        if (canL) {
            super.moveLeft();
        } else {
            pane.setRotate(-90);
            cannotRLUD();
            canL = true;
        }
    }

    public void moveUp() {
        if (canU) {
            super.moveUp();
        } else {
            pane.setRotate(0);
            cannotRLUD();
            canU = true;
        }
    }

    public void moveDown() {
        if (canD) {
            super.moveDown();
        } else {
            pane.setRotate(180);
            cannotRLUD();
            canD = true;
        }
    }
    public void fire(){
        setMap(map);
        if(!map.isQdestroyed()) {
            try{
                if(canR){
                    bullet.checkBarrier(map, 0, getPosition());
                    repoint();
                }
                else if(canL){
                    bullet.checkBarrier(map, 1, getPosition());
                    repoint();

                }
                else if(canU){
                    bullet.checkBarrier(map, 2, getPosition());
                    repoint();
                }
                else if(canD){
                    bullet.checkBarrier(map, 3, getPosition());
                    repoint();
                }
            }catch (InvalidMapException ex){
                //
            }
        }
    }
    public void defaultValue(){
        cannotRLUD();
        canU = true;
        pane.setRotate(0);
    }
}
