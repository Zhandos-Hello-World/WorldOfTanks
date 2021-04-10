package com.company;
import com.company.GUI.Barier.Barrier;
import com.company.GUI.Barier.BrickWall;
import com.company.GUI.Barier.SteelWall;
import com.company.GUI.Bullet.Bullet;
import com.company.GUI.Tanks.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.Scanner;
public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage)  {
        Tank[] tanks = {new WhiteTank(), new RedTank(), new YellowTank(), new GreenTank()};
        Bullet bullet = new Bullet();
        Barrier barrier = new BrickWall();
        Barrier barrier1 = new SteelWall();
        HBox hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setStyle("-fx-background-color: black");
        for(int i = 0; i < tanks.length; i++){
            hBox.getChildren().add(tanks[i].initializeOnTank());
        }
        hBox.getChildren().add(bullet.initializeOnBullet());
        hBox.getChildren().add(barrier.getBarrier());
        hBox.getChildren().add(barrier1.getBarrier());
        primaryStage.setScene(new Scene(hBox));
        primaryStage.show();
    }
    public static void logic(){
        GridPane mapUI = null;
        Scanner input = new Scanner(System.in);
        Player player = new MyPlayer();
        Game game = null;
        try{
            game = new Game(new Map(input));
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


