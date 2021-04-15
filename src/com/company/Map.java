package com.company;
import com.company.GUI.Barier.*;
import com.company.GUI.Settings;
import com.company.GUI.Tanks.*;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.Scanner;
public class Map implements Settings {
    private int N;
    private static char[][] NxN;
    private static GridPane mapUI;
    private int[] currentPlaceOfTank = new int[2];
    private Barrier barrier1 = new Null();
    private MyPlayer tank = new YellowTank();
    private Barrier[] barrier = {new Null(), new Water(), new SteelWall(), new Trees(), new BrickWall()};
    private Label labelOfTheHealth = new Label();
    Map(Scanner scanner, GridPane mapUI) throws InvalidMapException {
        setMapUI(mapUI);
        mapUI.setStyle("-fx-background-color: black");
        boolean checkPosition = false;
        this.N = scanner.nextInt();
        NxN = new char[N][N];
        for (int y = 0; y < getSize(); y++) {
            for (int x = 0; x < getSize(); x++) {
                char check = scanner.next().charAt(0);
                if (check == 'B' || check == '0' || check == 'P' || check == 'W' || check == 'S' || check == 'T') {
                    NxN[y][x] = check;
                    if (check == 'P') {
                        checkPosition = true;
                        mapUI.add(tank.initializeOnTank(), x, y);
                        currentPlaceOfTank[0] = y;
                        currentPlaceOfTank[1] = x;
                    } else if (check == 'B') {
                        mapUI.add(barrier[4].getBarrier(), x, y);
                    } else if (check == 'W') {
                        mapUI.add(barrier[1].getBarrier(), x, y);
                    } else if (check == 'S') {
                        mapUI.add(barrier[2].getBarrier(), x, y);
                    } else if (check == 'T') {
                        mapUI.add(barrier[3].getBarrier(), x, y);
                    }
                    else {
                        mapUI.add(barrier[0].getBarrier(), x, y);
                    }
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
    public void setHealth(int health){
        labelOfTheHealth.setText("Health: " + health);
        labelOfTheHealth.setPadding(new Insets(20, 20, 20, 20));

    }

    public HBox Run(){
        HBox hBox = new HBox();
        VBox vBox = new VBox();
        vBox.setStyle("-fx-background-color: #7F7F7FFF");
        vBox.getChildren().add(labelOfTheHealth);
        hBox.getChildren().addAll(mapUI, vBox);
        return hBox;
    }

    public GridPane getMapUI() {
        return mapUI;
    }

    public void setMapUI(GridPane mapUI) {
        Map.mapUI = mapUI;
    }

    public void setCurrentPosition(Position position) {
        mapUI.add(barrier1.getBarrier(), currentPlaceOfTank[1], currentPlaceOfTank[0]);
        NxN[currentPlaceOfTank[0]][currentPlaceOfTank[1]] = '0';
        currentPlaceOfTank[0] = position.getY();
        currentPlaceOfTank[1] = position.getX();
        NxN[position.getY()][position.getX()] = 'P';
        mapUI.add(tank.initializeOnTank(), currentPlaceOfTank[1], currentPlaceOfTank[0]);
    }

    public int getSize() {
        return this.N;
    }
    public void delete(Position position){
        mapUI.add(barrier[0].getBarrier(), position.getX(), position.getY());
        NxN[position.getY()][position.getX()] = '0';
    }

    public char getValueAt(int y, int x) throws InvalidMapException {
        if (x >= NxN.length || y >= NxN.length) {
            throw new InvalidMapException();
        }
        return NxN[y][x];
    }
    public void print() {
        for (char[] chars : NxN) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}