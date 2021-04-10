package com.company.GUI.Barier;

import com.company.GUI.Settings;
import com.company.GUI.Tanks.CustomRectangle;
import javafx.scene.layout.GridPane;

abstract public class Barrier implements Settings {
    protected CustomRectangle color1;
    protected CustomRectangle color2;
    protected CustomRectangle color3;
    protected CustomRectangle color4;
    abstract public GridPane getBarrier();
    //I am going to write logic barrier destroyed by fire of the tank
}
