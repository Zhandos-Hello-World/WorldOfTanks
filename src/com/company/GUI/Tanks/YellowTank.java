package com.company.GUI.Tanks;

import javafx.scene.paint.Color;

public class YellowTank extends Tank{
    public YellowTank(){
        this.mirrorColor = new Color(.91,.91,.58, 1);
        this.originalColor = new Color(.91,.61,.13, 1);
        this.shadowColor = new Color(.42,.42,0, 1);
        this.mirror = new CustomRectangle(this.mirrorColor, getPixel());
        this.original = new CustomRectangle(this.originalColor, getPixel());
        this.shadow = new CustomRectangle(this.shadowColor, getPixel());
    }
}
