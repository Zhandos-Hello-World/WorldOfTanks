package com.company;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
public class Client extends Application {
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;
    public static void main(String[]args)  {
        launch(args);
    }
    @Override
    public void start(Stage stage) {
        try {
            Socket socket = new Socket("localhost", 8000);
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(new Pane());

        scene.setOnKeyPressed(e -> {
            try {
                switch (e.getCode()){
                    case RIGHT: toServer.writeInt(0);break;
                    case LEFT: toServer.writeInt(1);break;
                    case DOWN: toServer.writeInt(2);break;
                    case UP: toServer.writeInt(3);break;
                    case SPACE:toServer.writeInt(4);break;
                    default:break;
                }
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        });
        stage.setScene(scene);
        stage.show();
    }
}

