package com.company.PreviousTanks;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CustomRectangle implements SettingsP {
    private Rectangle[]rectangles = new Rectangle[20];
    private int index;
    private Color color;
    private int pixelSize;


    public CustomRectangle(Color color, int pixelSize){
        this.color = color;
        this.pixelSize = pixelSize;
        for(int i = 0; i < rectangles.length; i++){
            rectangles[i] = new Rectangle(pixelSize, pixelSize, color);
            rectangles[i].setStroke(color);
        }
    }
    public Rectangle get(){
        if(index == rectangles.length){
            Rectangle[]temp = new Rectangle[index+10];
            for(int i = 0; i < rectangles.length; i++){
                temp[i] = rectangles[i];
            }
            for(int i = rectangles.length; i < temp.length; i++){
                temp[i] = new Rectangle(pixelSize, pixelSize, color);
                temp[i].setStroke(color);
            }
            rectangles = temp;
        }
        index++;
        return rectangles[index-1];
    }
}
