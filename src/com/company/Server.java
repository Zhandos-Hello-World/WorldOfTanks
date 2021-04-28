package com.company;

import com.company.GUI.Barier.*;
import com.company.GUI.Tanks.GreenTank;
import com.company.GUI.Tanks.RedTank;
import com.company.GUI.Tanks.WhiteTank;
import com.company.GUI.Tanks.YellowTank;
import com.company.PreviousTanks.*;
import com.company.offlineTwoPlayers.SecondPlayer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Server extends Application {

    private Button play = new Button("Play");
    private Button settings = new Button("Settings");
    private Button exit = new Button("Exit");
    private Button single = new Button("Single player");
    private Button multiplayerOn = new Button("(Online)multiplayer");
    private Button multiplayerOf = new Button("(Offline)multiplayer");
    private Button cancel = new Button("cancel");
    private VBox buttons = new VBox();
    private BorderPane Pane = new BorderPane();
    private Button start = new Button("Start");
    File file = new File("src\\com\\company\\Maps\\map1.txt");
    Color []colors = {new Color(.91,.61,.13, 1), new Color(.35,0,.48, 1),
    new Color(0,.32,0, 1), new Color(1,1,1, 1)};
    Label[] labels = {new Label("Player 1"), new Label("Player 2")};
    private static int choiceOfTheTank1 = 0;
    private static int choiceOfTheTank2 = 0;
    Tank []tanks1 = {new YellowTankP(), new RedTankP(), new GreenTankP(), new WhiteTankP()};
    Tank []tanks2 = {new YellowTankP(), new RedTankP(), new GreenTankP(), new WhiteTankP()};
    Label messageInvalid = new Label();
    public void mainScreen(){
        Button[]buttonsQ = {play, settings, exit};
        for(int i = 0; i < buttonsQ.length; i++){
            buttonsQ[i].setMinSize(400, 100);
            buttonsQ[i].setPadding(new Insets(30, 30, 30, 30));
            buttonsQ[i].getStylesheets().add("buttonsDesign.css");
        }
        installButtons(buttonsQ);
    }
    public void offlineChoice(){
        Button choiceOfTheMap = new Button("Map");
        choiceOfTheMap.setMinSize(200, 100);
        choiceOfTheMap.getStylesheets().add("buttonsDesign.css");

        for(int i = 0; i < labels.length; i++){
            labels[i].setFont(Font.font("Calibri Light", FontWeight.BOLD, FontPosture.ITALIC, 40));
            labels[i].setTextFill(new Color(1, 1, 1, 1));
            labels[i].setPadding(new Insets(30, 30, 30, 30));
        }
        labels[0].setTextFill(colors[choiceOfTheTank1]);
        labels[1].setTextFill(colors[choiceOfTheTank2]);

        GridPane buttons = new GridPane();

        Button left1 = new Button("<");
        Button right1 = new Button(">");
        Button left2 = new Button("<");
        Button right2 = new Button(">");
        Button cancel = new Button("cancel");
        Button[] instance = {left1, right1, left2, right2, cancel, start};
        for(int i = 0; i < instance.length; i++){
            if(i >= instance.length - 2){
                instance[i].setMinSize(200, 100);
                instance[i].getStylesheets().add("buttonsDesign.css");
            }
            else{
                instance[i].setMinSize(100, 100);
                instance[i].getStylesheets().add("buttonsDesign.css");
            }
        }
        FlowPane flowPane1 = new FlowPane(Orientation.HORIZONTAL);
        flowPane1.getChildren().addAll(left1, right1);

        FlowPane flowPane2 = new FlowPane(Orientation.HORIZONTAL);
        flowPane2.getChildren().addAll(left2, right2);



        buttons.add(choiceOfTheMap, 1, 0);
        buttons.add(tanks1[choiceOfTheTank1].initializeOnTank(), 0, 1);
        buttons.add(tanks2[choiceOfTheTank2].initializeOnTank(), 1, 1);
        buttons.add(labels[0], 0, 2);
        buttons.add(labels[1], 1, 2);
        buttons.add(flowPane1, 0, 3);
        buttons.add(flowPane2, 1, 3);
        buttons.add(cancel, 0, 4);
        buttons.add(start, 1, 4);
        buttons.add(messageInvalid, 0, 5);

        buttons.setPadding(new Insets(130, 200, 0, 200));
        Pane.setCenter(buttons);

        choiceOfTheMap.setOnAction(e -> {
            MapShow();
        });

        cancel.setOnAction(e -> {
            choicesButtons();
        });

        left1.setOnAction(e -> {
            if(choiceOfTheTank1 == 0){
                choiceOfTheTank1 = 3;
            }
            else{
                choiceOfTheTank1 -= 1;
            }
            buttons.add(tanks1[choiceOfTheTank1].initializeOnTank(), 0, 1);
            labels[0].setTextFill(colors[choiceOfTheTank1]);
        });
        left2.setOnAction(e -> {
            if(choiceOfTheTank2 == 0){
                choiceOfTheTank2 = 3;
            }
            else{
                choiceOfTheTank2 -= 1;
            }
            buttons.add(tanks2[choiceOfTheTank2].initializeOnTank(), 1, 1);
            labels[1].setTextFill(colors[choiceOfTheTank2]);

        });
        right1.setOnAction(e -> {
            if(choiceOfTheTank1 == 3){
                choiceOfTheTank1 = 0;
            }
            else{
                choiceOfTheTank1 += 1;
            }
            buttons.add(tanks1[choiceOfTheTank1].initializeOnTank(), 0, 1);
            labels[0].setTextFill(colors[choiceOfTheTank1]);


        });
        right2.setOnAction(e -> {
            if(choiceOfTheTank2 == 3){
                choiceOfTheTank2 = 0;
            }
            else{
                choiceOfTheTank2 += 1;
            }
            buttons.add(tanks2[choiceOfTheTank2].initializeOnTank(), 1, 1);
            labels[1].setTextFill(colors[choiceOfTheTank2]);
        });

    }
    public void MapShow(){
        VBox vBox = new VBox();
        Button[] buttonsMap = new Button[9];
        for(int i = 0; i < buttonsMap.length; i++){
            buttonsMap[i] = new Button("Map " + (i + 1));
            buttonsMap[i].getStylesheets().add("buttonsDesign.css");
            int finalI = i;
            buttonsMap[i].setOnAction(e -> {
                try {
                    PreviousMap p = new PreviousMap();
                    file = new File("src\\com\\company\\Maps\\map" + finalI + ".txt");
                    p.setMap(new Scanner(file));
                    Pane.setRight(null);
                    Pane.setRight(p.getMapGUI());
                }
                catch (FileNotFoundException | NoSuchElementException fileNotFoundException) {
                    Label label = new Label("File is not found");
                    label.setTextFill(new Color(1, 0, 0, 1));
                    label.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.ITALIC, 40));
                    Pane.setRight(label);
                } catch (ExceptionWithShow exceptionWithShow){
                    Label label = new Label(exceptionWithShow.getMessage());
                    label.setTextFill(new Color(1, 0, 0, 1));
                    label.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.ITALIC, 40));
                    Pane.setRight(label);
                }
            });
        }
        TextField textField = new TextField();
        textField.setMinWidth(200);
        textField.setMinHeight(50);
        textField.setStyle("-fx-background-color: #181B28FF; -fx-text-fill: white");
        textField.setPromptText("For example: C:\\U\\map.txt");
        Button custom_map= new Button("Custom map");
        custom_map.getStylesheets().add("buttonsDesign.css");
        custom_map.setOnAction(e->{
            file = new File(textField.getText());
            System.out.print(textField.getText());
            try {
                PreviousMap p = new PreviousMap();
                p.setMap(new Scanner(file));
                Pane.setRight(null);
                Pane.setRight(p.getMapGUI());
            }
            catch (FileNotFoundException | NoSuchElementException fileNotFoundException) {
                Label label = new Label("File is not found");
                label.setTextFill(new Color(1, 0, 0, 1));
                label.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.ITALIC, 40));
                Pane.setRight(label);
            } catch (ExceptionWithShow exceptionWithShow){
                Label label = new Label(exceptionWithShow.getMessage());
                label.setTextFill(new Color(1, 0, 0, 1));
                label.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.ITALIC, 40));
                Pane.setRight(label);
            }
        });
        vBox.getChildren().addAll(buttonsMap);
        vBox.getChildren().add(new HBox(textField, custom_map));
        Pane.setLeft(vBox);
        Pane.setCenter(null);

        Button saveAndClose = new Button("Save and close");
        saveAndClose.getStylesheets().add("buttonsDesign.css");
        Pane.setBottom(saveAndClose);
        saveAndClose.setOnAction(e->{
            Pane.setBottom(null);
            Pane.setCenter(null);
            Pane.setLeft(null);
            Pane.setRight(null);
            offlineChoice();
        });
    }

    public void choicesButtons(){
        buttons.getChildren().clear();
        Button[]choicesTypeOfTheGame = {single, multiplayerOn, multiplayerOf, cancel};
        for(int i = 0; i < choicesTypeOfTheGame.length; i++){
            choicesTypeOfTheGame[i].setMinSize(400, 100);
            choicesTypeOfTheGame[i].setPadding(new Insets(30, 30, 30, 30));
            choicesTypeOfTheGame[i].getStylesheets().add("buttonsDesign.css");
        }
        installButtons(choicesTypeOfTheGame);
        multiplayerOf.setOnAction(E -> {
            offlineChoice();
        });
        single.setOnAction(E -> {
            singlePlayer();
        });
        multiplayerOn.setOnAction(E -> {
            onlineChoice();
        });
    }


    public void onlineChoice(){

    }
    public void singlePlayer(){
        GridPane levels = new GridPane();
        Label textOfLevel = new Label("Levels");
        textOfLevel.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.ITALIC, 30));
        textOfLevel.setTextFill(new Color(1, 1, 1, 1));
        VBox platform = new VBox();
        Button[][] buttonOfLevels = new Button[4][4];
        int index = 1;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(index < 10){
                    buttonOfLevels[i][j] = new Button(String.valueOf(index));
                }
                else{
                    buttonOfLevels[i][j] = new Button(String.valueOf(index));
                }
                buttonOfLevels[i][j].getStylesheets().add("buttonsDesign.css");
                buttonOfLevels[i][j].setMinSize(100, 100);
                index++;
                levels.add(buttonOfLevels[i][j], j, i);
            }
        }
        platform.getChildren().addAll(textOfLevel, levels);
        platform.setPadding(new Insets(100, 0, 0, 200));
        Pane.setCenter(platform);
    }

    public void installButtons(Button[]Anybuttons){
        buttons.getChildren().clear();
        buttons.setCenterShape(true);
        buttons.setPadding(new Insets(130, 200, 200, 200));
        buttons.getChildren().addAll(Anybuttons);
        Pane.setCenter(buttons);
    }

    @Override
    public void start(Stage stage)  {
        Pane.setStyle("-fx-background-color: #21252BFF");
        Pane.setCenterShape(true);

        Label label = new Label("World of Tanks");
        label.setPadding(new Insets(0, 150, 0, 200));
        label.setFont(Font.font("Calibri Light", FontWeight.BLACK, FontPosture.REGULAR, 70));
        label.setTextFill(new Color(1, 1, 1, 1));
        Pane.setTop(label);

        mainScreen();
        Pane.setCenter(buttons);
        stage.setScene(new Scene(Pane, 800, 800));
        stage.setResizable(false);
        stage.show();


        play.setOnAction(E -> {
            choicesButtons();
        });
        cancel.setOnAction(E -> {
            mainScreen();
        });

        settings.setOnAction(E->{

        });

        exit.setOnAction(E -> {
            System.exit(1);
        });


        start.setOnAction(e -> {
            if(choiceOfTheTank1 == choiceOfTheTank2){
                messageInvalid.setText("You cannot choose the same color of equipment");
                messageInvalid.setWrapText(true);
                messageInvalid.setTextFill(new Color(1, 0, 0, 1));
            }
            else{
                messageInvalid.setText("");
                Pane = null;

                try {
                    stage.close();
                    Stage primaryStage = new Stage();
                    Player []myPlayer = {new YellowTank(), new RedTank(),  new GreenTank(),  new WhiteTank()};

                    GridPane gp = new GridPane();
                    Scanner scanner = new Scanner(file);
                    Map map = new Map(scanner, gp);
                    Game game = new Game(map);
                    Player player = myPlayer[choiceOfTheTank1];
                    SecondPlayer secondPlayer = new SecondPlayer();
                    secondPlayer.setColor(choiceOfTheTank2);
                    game.addPlayer(player);
                    game.addPlayer(secondPlayer);
                    HBox hBox = map.Run();
                    Scene scene = new Scene(hBox);
                    primaryStage.setScene(scene);
                    primaryStage.setResizable(false);
                    primaryStage.show();
                    scene.setOnKeyPressed(E ->{
                        switch (E.getCode()){
                            case RIGHT:player.moveRight();break;
                            case LEFT:player.moveLeft();break;
                            case DOWN:player.moveDown();break;
                            case UP:player.moveUp();break;
                            case SHIFT:player.fire();break;
                            case ESCAPE: primaryStage.close();break;
                            case W:secondPlayer.moveUp();break;
                            case A:secondPlayer.moveLeft();break;
                            case D:secondPlayer.moveRight();break;
                            case S:secondPlayer.moveDown();break;
                            case SPACE:secondPlayer.fire();break;
                            default:break;
                        }
                    });

                } catch (FileNotFoundException | InvalidMapException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }

        });
    }

    public static void main(String[]args){
        launch(args);
    }
}

class PreviousMap{
    private  char [][]Map;
    private  GridPane mapGUI = new GridPane();
    private  Barrier[] barrier = {new Null(), new Water(), new SteelWall(), new Trees(), new BrickWall()};
    public void setMap(Scanner scanner) throws ExceptionWithShow{
        int N = scanner.nextInt();
        Map = new char[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                char check = scanner.next().charAt(0);
                if (check == 'B' || check == '0' || check == 'P' || check == 'W' || check == 'S' || check == 'T' || check == 'Q') {
                    Map[i][j] = check;
                    if (check == 'B') {
                        mapGUI.add(barrier[4].getBarrier(), j, i);
                    } else if (check == 'W') {
                        mapGUI.add(barrier[1].getBarrier(), j, i);
                    } else if (check == 'S') {
                        mapGUI.add(barrier[2].getBarrier(), j, i);
                    } else if (check == 'T') {
                        mapGUI.add(barrier[3].getBarrier(), j, i);
                    }
                    else{
                        mapGUI.add(barrier[0].getBarrier(), j, i);
                    }
                }
                else{
                    throw new ExceptionWithShow();
                }
            }
        }
        scanner.close();
        if(size() == 0){
            throw new ExceptionWithShow("Size must not be 0");
        }
    }
    private int size(){
        return Map.length;
    }

    public GridPane getMapGUI(){
        return mapGUI;
    }

}
class ExceptionWithShow extends Exception{
    String message = "Wrong input in file";
    ExceptionWithShow(){
    }
    ExceptionWithShow(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
