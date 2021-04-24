package com.company;
import com.company.GUI.Tanks.*;
import com.company.offlineTwoPlayers.SecondPlayer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws InvalidMapException, FileNotFoundException {
        Scanner input = new Scanner(new File("src\\com\\company\\Level\\mapFirst.txt"));
        GridPane gp = new GridPane();
        Map map = new Map(input, gp);
        Game game = new Game(map);
        Player p = new YellowTank();
        SecondPlayer another = new SecondPlayer();
        game.addPlayer(p);
        game.addPlayer(another);
        HBox hBox = map.Run();
        Scene scene = new Scene(hBox);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        scene.setOnKeyPressed(E ->{
            switch (E.getCode()){
                case RIGHT:p.moveRight();break;
                case LEFT:p.moveLeft();break;
                case DOWN:p.moveDown();break;
                case UP:p.moveUp();break;
                case SPACE:p.fire();break;
                case ESCAPE: primaryStage.close();break;
                case W:another.moveUp();break;
                case A:another.moveLeft();break;
                case D:another.moveRight();break;
                case S:another.moveDown();break;
                case F:another.fire();break;
                default:break;
            }
        });
    }
    public static void logic(){
        GridPane mapUI = null;
        Scanner input = new Scanner(System.in);
        Player player = new RedTank();
        Game game = null;
        try{
            game = new Game(new Map(input, new GridPane()));
        }
        catch(InvalidMapException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        game.addPlayer(player);
        String moves = input.next();
        char move;
        for(int i=0; i<moves.length(); i++){
            move = moves.charAt(i);
            switch(move){
                case 'R':
                    player.moveRight();
                    break;
                case 'L':
                    player.moveLeft();
                    break;
                case 'U':
                    player.moveUp();
                    break;
                case 'D':
                    player.moveDown();
                    break;
            }
        }
    }
}


