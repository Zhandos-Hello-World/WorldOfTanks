package com.company;
import com.company.GUI.Tanks.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Scanner;
public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws InvalidMapException {
        Scanner input = new Scanner(System.in);
        GridPane gp = new GridPane();
        Map map = new Map(input, gp);
        Game game = new Game(map);
        Player p = new RedTank();
        game.addPlayer(p);
        primaryStage.setScene(new Scene(map.getMapUI()));
        primaryStage.show();
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


