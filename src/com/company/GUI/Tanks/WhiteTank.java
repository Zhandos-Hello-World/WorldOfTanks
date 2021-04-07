package com.company.GUI.Tanks;

import javafx.scene.paint.Color;

public class WhiteTank extends Tank{
    public WhiteTank(){
        this.mirrorColor = new Color(1,1,1, 1);
        this.originalColor = new Color(.42,.42,.42, 1);
        this.shadowColor = new Color(0,.17,.20, 1);
        this.mirror = new CustomRectangle(this.mirrorColor, pixel);
        this.original = new CustomRectangle(this.originalColor, pixel);
        this.shadow = new CustomRectangle(this.shadowColor, pixel);
    }
}
