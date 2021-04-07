package com.company.GUI.mainScreen;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class mainScreen {
    private Stage stage;
    private BorderPane root;
    private VBox rootForButtonsV;
    private HBox rootForButtonsH;
    private StackPane stackPane;
    private Rectangle rectangle;

    public void start(){
        Button[]buttons = new Button[]{new Button("Play"), new Button("Settings"), new Button("Help")};
        for(int i = 0; i < buttons.length; i++){
            buttons[i].setStyle("-fx-background-color: black; -fx-background-radius: 12; -fx-stroke: #24292EFF; -fx-text-fill: white");
            buttons[i].setMinSize(40, 40);
        }
        StackPane stackPane = new StackPane();
        stackPane.setStyle("-fx-background-color: black");

        rectangle = new Rectangle(600, 500);
        rectangle.setStroke(new Color(.14,.16,.18, 1));
        rectangle.setFill(new Color(0,0,0,1));
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);

        rootForButtonsV = new VBox();
        rootForButtonsV.setPadding(new Insets(20,20,20,20));
        rootForButtonsV.getChildren().addAll(buttons);

        stackPane.getChildren().add(rectangle);
        stackPane.getChildren().add(rootForButtonsV);
        stage = new Stage();
        stage.setScene(new Scene(stackPane));
        stage.show();
    }
}
