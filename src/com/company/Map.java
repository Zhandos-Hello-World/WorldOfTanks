package com.company;

import com.company.GUI.Barier.*;
import com.company.GUI.Settings;
import com.company.GUI.Tanks.GreenTank;
import com.company.GUI.Tanks.RedTank;
import com.company.GUI.Tanks.WhiteTank;
import com.company.GUI.Tanks.YellowTank;
import com.company.offlineTwoPlayers.SecondPlayer;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.Scanner;
public class Map implements Settings {
    public static Pane pane;
    private int N;
    private static char[][] NxN;
    private static GridPane mapUI;
    private int[] currentPlaceOfTank = new int[2];
    private int[] currentPlaceOFTheAnotherTank = new int[2];
    private Barrier barrier1 = new Null();
    private static MyPlayer tank = new YellowTank();
    private Barrier[] barrier = {new Null(), new Water(), new SteelWall(), new Trees(), new BrickWall()};
    private static Label labelOfTheHealthP = new Label();
    private static Label labelOfTheHealthQ = new Label();
    private static SecondPlayer another = new SecondPlayer();
    private int attendance = 0;
    private int attendanceAnother = 0;
    private boolean Qdestroyed = false;
    private boolean Pdestroyed = false;
    private static Position spawnPointQ;
    private static Position spawnPointP;
    private static int healthQ = 3;
    private static int healthP = 3;
    VBox messageAboutGame;


    Map(Scanner scanner, GridPane mapUI) throws InvalidMapException {
        setMapUI(mapUI);
        mapUI.setStyle("-fx-background-color: black");
        boolean checkPosition = false;
        this.N = scanner.nextInt();
        NxN = new char[N][N];
        for (int y = 0; y < getSize(); y++) {
            for (int x = 0; x < getSize(); x++) {
                char check = scanner.next().charAt(0);
                if (check == 'B' || check == '0' || check == 'P' || check == 'W' || check == 'S' || check == 'T' || check == 'Q') {
                    NxN[y][x] = check;
                    if (check == 'P') {
                        checkPosition = true;
                        mapUI.add(tank.initializeOnTank(), x, y);
                        currentPlaceOfTank[0] = y;
                        currentPlaceOfTank[1] = x;
                        spawnPointP = new Position(x, y);
                    } else if (check == 'B') {
                        mapUI.add(barrier[4].getBarrier(), x, y);
                    } else if (check == 'W') {
                        mapUI.add(barrier[1].getBarrier(), x, y);
                    } else if (check == 'S') {
                        mapUI.add(barrier[2].getBarrier(), x, y);
                    } else if (check == 'T') {
                        mapUI.add(barrier[3].getBarrier(), x, y);
                    } else if (check == 'Q'){
                        mapUI.add(another.initializeOnTank(), x, y);
                        currentPlaceOFTheAnotherTank[0] = y;
                        currentPlaceOFTheAnotherTank[1] = x;
                        spawnPointQ = new Position(x, y);
                    }
                    else {
                        mapUI.add(barrier[0].getBarrier(), x, y);
                    }
                    pane = new Pane(mapUI);
                    pane.setStyle("-fx-background-color: #7F7F7FFF");
                    pane.setPadding(new Insets(5, 5, 5, 5));
                    setHealthP(healthP);
                    setHealthQ(healthQ);
                } else {
                    throw new InvalidMapException();
                }
            }
        }
        scanner.close();
        //here p is absent or size of the Matrix equals 0
        if (!checkPosition || N == 0) {
            throw new InvalidMapException("Map size can not be zero");
        }
    }
    public void setHealthP(int health){
        labelOfTheHealthP.setText("Health of the Player1: " + health);
        labelOfTheHealthP.setPadding(new Insets(20, 20, 20, 20));
    }
    public void setHealthQ(int health){
        labelOfTheHealthQ.setText("Health of the Player2: " + health);
        labelOfTheHealthQ.setPadding(new Insets(20, 20, 20, 20));
    }
    public static void setColorP(int i){
        switch (i){
            case 0:tank = new YellowTank();break;
            case 1:tank = new RedTank();break;
            case 2:tank = new GreenTank();break;
            case 3:tank = new WhiteTank();break;
        }
    }
    public static void setColorQ(int i){
        another.setColor(i);
    }

    public HBox Run(){
        HBox hBox = new HBox();
        messageAboutGame = new VBox();
        messageAboutGame.setStyle("-fx-background-color: #7F7F7FFF");
        messageAboutGame.getChildren().addAll(labelOfTheHealthP, labelOfTheHealthQ);
        hBox.getChildren().addAll(pane, messageAboutGame);
        return hBox;
    }

    public void setMapUI(GridPane mapUI) {
        Map.mapUI = mapUI;
    }
    public char[][] returnNxN(){
        return NxN;
    }

    public void setCurrentPosition(Position position) {
        Position temp = new Position(currentPlaceOFTheAnotherTank[1], currentPlaceOFTheAnotherTank[0]);
        if(!Pdestroyed && !position.equals(temp)){
            if(NxN[position.getY()][position.getX()] == 'T' && attendance == 1){
                mapUI.add(barrier[3].getBarrier(), currentPlaceOfTank[1], currentPlaceOfTank[0]);
                NxN[currentPlaceOfTank[0]][currentPlaceOfTank[1]] = 'T';
                currentPlaceOfTank[0] = position.getY();
                currentPlaceOfTank[1] = position.getX();
                NxN[position.getY()][position.getX()] = 'T';
                mapUI.add(barrier[3].getBarrier(), currentPlaceOfTank[1], currentPlaceOfTank[0]);
                attendance = 1;
            }
            else if(NxN[position.getY()][position.getX()] != 'T' && attendance == 1){
                mapUI.add(barrier[3].getBarrier(), currentPlaceOfTank[1], currentPlaceOfTank[0]);
                NxN[currentPlaceOfTank[0]][currentPlaceOfTank[1]] = 'T';
                currentPlaceOfTank[0] = position.getY();
                currentPlaceOfTank[1] = position.getX();
                NxN[position.getY()][position.getX()] = 'P';
                mapUI.add(tank.initializeOnTank(), currentPlaceOfTank[1], currentPlaceOfTank[0]);
                attendance = 0;
            }
            else if(NxN[position.getY()][position.getX()] == 'T' && attendance != 1){
                attendance = 1;
                mapUI.add(barrier1.getBarrier(), currentPlaceOfTank[1], currentPlaceOfTank[0]);
                NxN[currentPlaceOfTank[0]][currentPlaceOfTank[1]] = '0';
                currentPlaceOfTank[0] = position.getY();
                currentPlaceOfTank[1] = position.getX();
                NxN[position.getY()][position.getX()] = 'T';
                mapUI.add(barrier[3].getBarrier(), currentPlaceOfTank[1], currentPlaceOfTank[0]);
            }
            else{
                mapUI.add(barrier1.getBarrier(), currentPlaceOfTank[1], currentPlaceOfTank[0]);
                NxN[currentPlaceOfTank[0]][currentPlaceOfTank[1]] = '0';
                currentPlaceOfTank[0] = position.getY();
                currentPlaceOfTank[1] = position.getX();
                NxN[position.getY()][position.getX()] = 'P';
                mapUI.add(tank.initializeOnTank(), currentPlaceOfTank[1], currentPlaceOfTank[0]);
            }
        }
    }
    public void setCurrentPositionAnother(Position position) {
        Position temp = new Position(currentPlaceOfTank[1], currentPlaceOfTank[0]);
        if(!Qdestroyed && !position.equals(temp)){
            if(NxN[position.getY()][position.getX()] == 'T' &&  attendanceAnother  == 1){
                mapUI.add(barrier[3].getBarrier(), currentPlaceOFTheAnotherTank[1], currentPlaceOFTheAnotherTank[0]);
                NxN[currentPlaceOFTheAnotherTank[0]][currentPlaceOFTheAnotherTank[1]] = 'T';
                currentPlaceOFTheAnotherTank[0] = position.getY();
                currentPlaceOFTheAnotherTank[1] = position.getX();
                NxN[position.getY()][position.getX()] = 'T';
                mapUI.add(barrier[3].getBarrier(), currentPlaceOFTheAnotherTank[1], currentPlaceOFTheAnotherTank[0]);
                attendanceAnother = 1;
            }
            else if(NxN[position.getY()][position.getX()] != 'T' &&  attendanceAnother  == 1){
                mapUI.add(barrier[3].getBarrier(), currentPlaceOFTheAnotherTank[1], currentPlaceOFTheAnotherTank[0]);
                NxN[currentPlaceOFTheAnotherTank[0]][currentPlaceOFTheAnotherTank[1]] = 'T';
                currentPlaceOFTheAnotherTank[0] = position.getY();
                currentPlaceOFTheAnotherTank[1] = position.getX();
                NxN[position.getY()][position.getX()] = 'Q';
                mapUI.add(another.initializeOnTank(), currentPlaceOFTheAnotherTank[1], currentPlaceOFTheAnotherTank[0]);
                attendanceAnother = 0;
            }
            else if(NxN[position.getY()][position.getX()] == 'T' &&  attendanceAnother  != 1){
                attendanceAnother  = 1;
                mapUI.add(barrier1.getBarrier(), currentPlaceOFTheAnotherTank[1], currentPlaceOFTheAnotherTank[0]);
                NxN[currentPlaceOFTheAnotherTank[0]][currentPlaceOFTheAnotherTank[1]] = '0';
                currentPlaceOFTheAnotherTank[0] = position.getY();
                currentPlaceOFTheAnotherTank[1] = position.getX();
                NxN[position.getY()][position.getX()] = 'T';
                mapUI.add(barrier[3].getBarrier(), currentPlaceOFTheAnotherTank[1], currentPlaceOFTheAnotherTank[0]);
            }
            else{
                mapUI.add(barrier1.getBarrier(), currentPlaceOFTheAnotherTank[1], currentPlaceOFTheAnotherTank[0]);
                NxN[currentPlaceOFTheAnotherTank[0]][currentPlaceOFTheAnotherTank[1]] = '0';
                currentPlaceOFTheAnotherTank[0] = position.getY();
                currentPlaceOFTheAnotherTank[1] = position.getX();
                NxN[position.getY()][position.getX()] = 'Q';
                mapUI.add(another.initializeOnTank(), currentPlaceOFTheAnotherTank[1], currentPlaceOFTheAnotherTank[0]);
            }
        }
    }


    public int getSize() {
        return this.N;
    }
    public void delete(Position position){
        if(NxN[position.getY()][position.getX()] != 'S'){
            if(NxN[position.getY()][position.getX()] == 'P'){
                healthP-=1;
                if(healthP <= 0){
                    Pdestroyed = true;
                    NxN[spawnPointP.getY()][spawnPointP.getX()] = '0';
                    NxN[position.getY()][position.getX()] = '0';
                    setHealthP(healthP);
                    messageAboutGame.getChildren().add(new Label("Player 2 is won"));
                    Button quit = new Button("Quit");
                    messageAboutGame.getChildren().add(quit);
                    quit.setOnAction(e -> System.exit(1));
                    mapUI.add(barrier[0].getBarrier(), position.getX(), position.getY());
                    mapUI.add(barrier[0].getBarrier(), spawnPointP.getX(), spawnPointP.getY());
                }
                else{
                    NxN[position.getY()][position.getX()] = '0';
                    mapUI.add(barrier[0].getBarrier(), position.getX(), position.getY());
                    tank.defaultValue();
                    setHealthP(healthP);
                    Pdestroyed = false;
                    NxN[spawnPointP.getY()][spawnPointP.getX()] = 'P';
                    mapUI.add(tank.initializeOnTank(), spawnPointP.getX(), spawnPointP.getY());
                    currentPlaceOfTank[0] = spawnPointP.getY();
                    currentPlaceOfTank[1] = spawnPointP.getX();
                }
            }
            else if(NxN[position.getY()][position.getX()] == 'Q'){
                healthQ-=1;
                if(healthQ <= 0){
                    Qdestroyed = true;
                    NxN[spawnPointQ.getY()][spawnPointQ.getX()] = '0';
                    NxN[position.getY()][position.getX()] = '0';
                    mapUI.add(barrier[0].getBarrier(), position.getX(), position.getY());
                    mapUI.add(barrier[0].getBarrier(), spawnPointP.getX(), spawnPointQ.getY());
                    setHealthQ(healthQ);

                    messageAboutGame.getChildren().add(new Label("Player 1 is won"));
                    Button quit = new Button("Quit");
                    messageAboutGame.getChildren().add(quit);
                    quit.setOnAction(e -> System.exit(1));
                }
                else{
                    NxN[position.getY()][position.getX()] = '0';
                    mapUI.add(barrier[0].getBarrier(), position.getX(), position.getY());
                    another.defaultValue();
                    setHealthQ(healthQ);
                    Qdestroyed = false;
                    NxN[spawnPointQ.getY()][spawnPointQ.getX()] = 'Q';
                    mapUI.add(another.initializeOnTank(), spawnPointQ.getX(), spawnPointQ.getY());
                    currentPlaceOFTheAnotherTank[0] = spawnPointQ.getY();
                    currentPlaceOFTheAnotherTank[1] = spawnPointQ.getX();
                }
            }
            else{
                NxN[position.getY()][position.getX()] = '0';
                mapUI.add(barrier[0].getBarrier(), position.getX(), position.getY());
            }
        }
        print();
        System.out.println();
    }
    public boolean isQdestroyed(){
        return Qdestroyed;
    }
    public boolean isPdestroyed(){
        return Pdestroyed;
    }

    public char getValueAt(int y, int x) throws InvalidMapException {
        if (x >= NxN.length || y >= NxN.length) {
            throw new InvalidMapException();
        }
        return NxN[y][x];
    }

    public  void print() {
        for (char[] chars : NxN) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}