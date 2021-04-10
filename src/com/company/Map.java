package com.company;

import com.company.GUI.Barier.Barrier;
import com.company.GUI.Barier.BrickWall;
import com.company.GUI.Barier.Null;
import com.company.GUI.Barier.Trees;
import com.company.GUI.Settings;
import com.company.GUI.Tanks.CustomRectangle;
import com.company.GUI.Tanks.RedTank;
import com.company.GUI.Tanks.Tank;
import com.company.GUI.Tanks.GreenTank;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Scanner;

public class Map implements Settings {
    private int N;
    private char [][]NxN;
    private Tank userTank;
    private static GridPane mapUI;
    Map(Scanner scanner, GridPane mapUI) throws InvalidMapException{
        setMapUI(mapUI);
        mapUI.setStyle("-fx-background-color: black");
        Barrier barrier = new Trees();
        Barrier barrier1 = new Null();
        MyPlayer tank = new RedTank();

        boolean checkPosition = false;
        this.N = scanner.nextInt();
        NxN = new char[N][N];
        for(int y = 0; y < getSize(); y++){
            for(int x = 0; x < getSize(); x++){
                char check = scanner.next().charAt(0);
                if(check == '1' || check == '0' || check == 'P'){
                    if(check == 'P'){
                        checkPosition = true;
                        mapUI.add(tank.initializeOnTank(), x, y);
                    }
                    else if(check == '1'){
                        mapUI.add(barrier.getBarrier(), x, y);
                    }
                    else{
                        mapUI.add(barrier1.getBarrier(), x, y);
                    }
                    NxN[y][x] = check;
                }
                else{
                    throw new InvalidMapException();
                }
            }
        }
        //here p is absent or size of the Matrix equals 0
        if(!checkPosition || N == 0){
            throw new InvalidMapException("Map size can not be zero");
        }
        else{
            userTank = new GreenTank();
        }
    }

    public GridPane getMapUI() {
        return mapUI;
    }

    public void setMapUI(GridPane mapUI) {
        Map.mapUI = mapUI;
    }

    public void setUserTank(Tank userTank) {
        this.userTank = userTank;
    }

    public Tank getUserTank() {
        return userTank;
    }

    int getSize(){
        return this.N;
    }


    public char getValueAt(int y, int x) throws InvalidMapException{
        if(x >= NxN.length || y >= NxN.length){
            throw new InvalidMapException();
        }
        return NxN[y][x];
    }
    public void print(){
        for (char[] chars : NxN) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}