package com.company.GUI.Barier;

import com.company.GUI.Tanks.CustomRectangle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BrickWall extends Barrier{
    private GridPane gridPane;
    public BrickWall(){
        this.color1 = new CustomRectangle(new Color(.61,0,0, 1),getPixel());
        this.color2 = new CustomRectangle(new Color(.81,.40,0, 1), getPixel());
        this.color3 = new CustomRectangle(new Color(.51,.51,.51, 1), getPixel());
    }
    private void title(int i){
        for(int j = 0; j <= 3; j++){
            gridPane.add(color1.get(), j, i);
        }
        gridPane.add(color3.get(), 4, i);
        for(int j = 5; j <= 10; j++){
            gridPane.add(color1.get(), j, i);
        }
        gridPane.add(color3.get(), 11, i);
        for(int j = 12; j <= 15; j++){
            gridPane.add(color1.get(), j, i);
        }

        for(int j = 0; j <= 3; j++){
            gridPane.add(color2.get(), j, i + 1);
            gridPane.add(color2.get(), j, i + 2);
        }
        gridPane.add(color3.get(), 4, i + 1);
        gridPane.add(color1.get(), 5, i + 1);

        gridPane.add(color3.get(), 4, i + 2);
        gridPane.add(color1.get(), 5, i + 2);
        for(int j = 6; j <= 10; j++){
            gridPane.add(color2.get(), j, i + 1);
            gridPane.add(color2.get(), j, i + 2);
        }

        gridPane.add(color3.get(), 11, i + 1);
        gridPane.add(color1.get(), 12, i + 1);

        gridPane.add(color3.get(), 11, i + 2);
        gridPane.add(color1.get(), 12, i + 2);
        for(int j = 13; j <= 15; j++){
            gridPane.add(color2.get(), j, i + 1);
            gridPane.add(color2.get(), j, i + 2);
        }

        for(int j = 0; j < 16; j++){
            gridPane.add(color3.get(), j, i + 3);
        }
    }

    private void titleSecond(int i){
        gridPane.add(color3.get(), 0, i);
        for(int j = 1; j <= 7; j++){
            gridPane.add(color1.get(), j, i);
        }
        gridPane.add(color3.get(), 8, i);
        for(int j = 9; j <= 15; j++){
            gridPane.add(color1.get(), j, i);
        }


        gridPane.add(color3.get(), 0, i + 1);
        gridPane.add(color1.get(), 1, i + 1);
        for(int t = 2; t <= 7; t++){
            gridPane.add(color2.get(), t, i + 1);
        }
        gridPane.add(color3.get(), 8, i + 1);
        gridPane.add(color1.get(), 9, i + 1);
        for(int t = 10; t <= 15; t++){
            gridPane.add(color2.get(), t, i + 1);
        }

        gridPane.add(color3.get(), 0, i + 2);
        gridPane.add(color1.get(), 1, i + 2);
        for(int t = 2; t <= 7; t++){
            gridPane.add(color2.get(), t, i + 2);
        }
        gridPane.add(color3.get(), 8, i + 2);
        gridPane.add(color1.get(), 9, i + 2);
        for(int t = 10; t <= 15; t++){
            gridPane.add(color2.get(), t, i + 2);
        }
        for(int t = 0; t <= 15; t++){
            gridPane.add(color3.get(), t, i + 3);
        }
    }

    @Override
    public GridPane getBarrier(){
        gridPane = new GridPane();
        title(0);
        titleSecond(4);
        title(8);
        titleSecond(12);
        return gridPane;
    }
    @Override
    public boolean ableToDestroyed(){
        return true;
    }


}
