package com.company;

import com.company.GUI.Tanks.*;
import com.company.offlineTwoPlayers.SecondPlayer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Server extends Application {
    private int x = 3;
    private DataInputStream inputFromClient = null;
    private DataOutputStream outputStream = null;
    private Map map;
    public static void main(String[]args){
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) throws InvalidMapException, FileNotFoundException {
        int choiceOfTheTank1 = 3;
        GridPane gp = new GridPane();
        Scanner scanner = new Scanner(new File("src\\com\\company\\Level\\mapFirst.txt"));
        Stage primaryStage = new Stage();
        Player []myPlayer = {new YellowTank(), new RedTank(),  new GreenTank(),  new WhiteTank()};
        map = new Map(scanner, gp);
        Game game = new Game(map);
        Player player = myPlayer[choiceOfTheTank1];
        SecondPlayer secondPlayer = new SecondPlayer();
        secondPlayer.setColor(choiceOfTheTank1);
        game.addPlayer(player);
        game.addPlayer(secondPlayer);
        HBox hBox = map.Run();
        Scene scene = new Scene(hBox);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        scene.setOnKeyPressed(E ->{
            switch (E.getCode()){
                case UP:secondPlayer.moveUp();break;
                case LEFT:secondPlayer.moveLeft();break;
                case RIGHT:secondPlayer.moveRight();break;
                case DOWN:secondPlayer.moveDown();break;
                case SPACE:secondPlayer.fire();break;
                case ESCAPE: primaryStage.close();break;
                default:break;
            }
        });
        try{
            ServerSocket serverSocket = new ServerSocket(723);
            new Thread(() -> {
                try {
                    Socket socket = serverSocket.accept();
                    inputFromClient = new DataInputStream(socket.getInputStream());
                    outputStream = new DataOutputStream(socket.getOutputStream());
                    System.out.println("Server started " + new Date());
                    send();
                    while(true){
                        x = inputFromClient.readInt();
                        Platform.runLater(() -> {
                            try{
                                switch (x){
                                    case 0: player.moveRight();send();break;
                                    case 1: player.moveLeft();send();break;
                                    case 2: player.moveDown();send();break;
                                    case 3: player.moveUp();send();break;
                                    case 4: player.fire();send();break;
                                }
                            }
                            catch (IOException ex){
                                ex.printStackTrace();
                            }
                        });
                        send();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public void send() throws IOException{
        outputStream.writeInt(map.getSize());
        for(int i = 0; i < map.getSize(); i++){
            for(int j = 0; j < map.getSize(); j++){
                outputStream.writeChar(map.returnNxN()[i][j]);
            }
        }
    }
}