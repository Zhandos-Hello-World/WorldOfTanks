package com.company;

import com.company.GUI.Barier.*;
import com.company.GUI.Settings;
import com.company.GUI.Tanks.RedTank;
import javafx.scene.layout.GridPane;

import java.util.Scanner;

public class Map implements Settings {
    private int N;
    private char [][]NxN;

    private static GridPane mapUI;
    private int[] currentPlaceOfTank = new int[2];
    private Barrier barrier1 = new Null();
    private static MyPlayer tank = new RedTank();
    Map(Scanner scanner, GridPane mapUI) throws InvalidMapException{
        setMapUI(mapUI);
        mapUI.setStyle("-fx-background-color: black");
        Barrier barrier = new BrickWall();

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
                        currentPlaceOfTank[0] = y;
                        currentPlaceOfTank[1] = x;
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
    }

    public GridPane getMapUI() {
        return mapUI;
    }

    public void setMapUI(GridPane mapUI) {
        Map.mapUI = mapUI;
    }


    public void setCurrentPosition(Position position){
        mapUI.add(barrier1.getBarrier(), currentPlaceOfTank[1], currentPlaceOfTank[0]);
        currentPlaceOfTank[0] = position.getY();
        currentPlaceOfTank[1] = position.getX();
        mapUI.add(tank.initializeOnTank(), currentPlaceOfTank[1], currentPlaceOfTank[0]);
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