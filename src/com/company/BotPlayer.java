package com.company;

import com.company.GUI.Tanks.CustomRectangle;
import com.company.GUI.Tanks.Tank;
import javafx.application.Platform;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class BotPlayer extends Tank implements Player{
    private static boolean canR, canU = true, canD, canL;
    private static int[][] wave;
    private static boolean[]liveBot;
    public static void setWave(int waves){
        wave = new int[waves][2];
        liveBot = new boolean[waves];
        Arrays.fill(liveBot, true);
    }

    BotPlayer(){
        this.mirrorColor = new Color(1,1,1, 1);
        this.originalColor = new Color(.42,.42,.42, 1);
        this.shadowColor = new Color(0,.17,.20, 1);
        this.mirror = new CustomRectangle(this.mirrorColor, getPixel());
        this.original = new CustomRectangle(this.originalColor, getPixel());
        this.shadow = new CustomRectangle(this.shadowColor, getPixel());
    }

    @Override
    public void setMap(Map map) {
        this.map = map;
    }
    private void cannotRLUD() {
        canD = false;
        canR = false;
        canL = false;
        canU = false;
    }
    public void start(){
        boolean check = true;
        Position temp = new Position(0, 0);
        try{
            while(check){
                int random = (int)(Math.random() * (map.getSize() - 1) + 0);
                for(int i = 0; i < map.getSize(); i++){
                    if(map.getValueAt(0, random) == '0'){
                        temp = new Position(i, 0);
                        check = false;
                        break;
                    }
                }
            }
        }
        catch (InvalidMapException ex){
            ex.printStackTrace();
        }
        map.spawnBot(temp);
        setMap(map);
        repoint();
        new Thread(() -> {
            try{
                while (true){
                    Platform.runLater(()->{
                        try{
                            int up = 0, down = 0, left = 0, right = 0;
                            for(int i = y; i < map.getSize(); i++){
                                if(map.getValueAt(i, x) != 'S' && map.getValueAt(i, x) != 'W'){
                                    down++;
                                }
                            }
                            for(int i = y; i >= 0; i--){
                                if(map.getValueAt(i, x) != 'S' && map.getValueAt(i,x) != 'W'){
                                    up++;
                                }
                            }
                            for(int i = x; i < map.getSize(); i++){
                                if(map.getValueAt(y, i) != 'S' && map.getValueAt(y, i) != 'W'){
                                    right++;
                                }
                            }
                            for(int i = x; i >= 0; i--){
                                if(map.getValueAt(y, i) != 'S' && map.getValueAt(y, i) != 'W'){
                                    left++;
                                }
                            }
                            int[]arr = {up, down, left, right};
                            String[]arrS = {"up", "down", "left", "right"};
                            boolean checking = true;
                            while(checking){
                                checking = false;
                                for(int j = 1; j < arr.length; j++){
                                    if(arr[j - 1] > arr[j]){
                                        int tempInt = arr[j - 1];
                                        arr[j - 1] = arr[j];
                                        arr[j] = arr[j - 1];

                                        String tempS = arrS[j - 1];
                                        arrS[j - 1] = arrS[j];
                                        arrS[j] = tempS;

                                        checking = true;
                                    }
                                }
                            }
                            switch (arrS[arrS.length - 1]){
                                case "up":moveUp();break;
                                case "down":moveDown();break;
                                case "left":moveLeft();break;
                                case "right":moveRight();break;
                            }
                        }catch (InvalidMapException ex){

                        }
                    });
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }).start();
    }

    @Override
    public void moveRight() {
        if (canR) {
            setMap(map);
            repoint();
            if(((map.getSize() > x + 1) && (NxN[y][x + 1] == '0' || NxN[y][x + 1] == 'T'))){
                if(NxN[y][x + 1] == '0'){
                    NxN[y][x] = '0';
                    x += 1;
                    NxN[y][x] = 'Q';
                    map.setCurrentPositionAnother(new Position(x, y));
                    setMap(map);
                }
                else if(NxN[y][x + 1] == 'T'){
                    NxN[y][x] = '0';
                    x += 1;
                    NxN[y][x] = 'T';
                    map.setCurrentPositionAnother(new Position(x, y));
                    setMap(map);
                }
            }
        } else {
            pane.setRotate(90);
            cannotRLUD();
            canR = true;
        }
    }
    @Override
    public void moveLeft() {
        if (canL) {
            setMap(map);
            repoint();
            if(!(-1 == x - 1) && (NxN[y][x - 1] == '0' || NxN[y][x - 1] == 'T')){
                if(NxN[y][x - 1] == '0'){
                    NxN[y][x] = '0';
                    x -= 1;
                    NxN[y][x] = 'Q';
                    map.setCurrentPositionAnother(new Position(x, y));
                    setMap(map);
                }
                else if(NxN[y][x - 1] == 'T'){
                    NxN[y][x] = '0';
                    x -= 1;
                    NxN[y][x] = 'T';
                    map.setCurrentPositionAnother(new Position(x, y));
                    setMap(map);
                }
            }
        } else {
            pane.setRotate(-90);
            cannotRLUD();
            canL = true;
        }
    }
    @Override
    public void moveUp() {
        if (canU) {
            setMap(map);
            repoint();
            map.print();
            System.out.println();
            if(!(-1 == y - 1) && (NxN[y - 1][x] == '0' || NxN[y - 1][x] == 'T')) {
                if(NxN[y - 1][x] == '0'){
                    NxN[y][x] = '0';
                    y -= 1;
                    NxN[y][x] = 'Q';
                    map.setCurrentPositionAnother(new Position(x, y));
                    setMap(map);
                }
                else if(NxN[y - 1][x] == 'T'){
                    NxN[y][x] = '0';
                    y -= 1;
                    NxN[y][x] = 'T';
                    map.setCurrentPositionAnother(new Position(x, y));
                    setMap(map);
                }
            }
        } else {
            pane.setRotate(0);
            cannotRLUD();
            canU = true;
        }
    }
    @Override
    public void moveDown() {
        if (canD) {
            setMap(map);
            repoint();
            if((map.getSize() > y + 1) && (NxN[y + 1][x] == '0' || NxN[y + 1][x] == 'T')){
                if (NxN[y + 1][x] == '0') {
                    NxN[y][x] = '0';
                    y += 1;
                    NxN[y][x] = 'Q';
                    map.setCurrentPositionAnother(new Position(x, y));
                    setMap(map);
                }
                else if(NxN[y + 1][x] == 'T'){
                    NxN[y][x] = '0';
                    y += 1;
                    NxN[y][x] = 'T';
                    map.setCurrentPositionAnother(new Position(x, y));
                    setMap(map);
                }
            }
        } else {
            pane.setRotate(180);
            cannotRLUD();
            canD = true;
        }
    }

    @Override
    public Position getPosition() {
        return new Position(x, y);
    }

    @Override
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

    @Override
    public void fire() {
        setMap(map);
        if(!map.isPdestroyed()) {
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
}