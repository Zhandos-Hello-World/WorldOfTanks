package com.company.GUI.Tanks;

import javafx.scene.paint.Color;

public class GreenTank extends Tank {
    public GreenTank(){
        this.mirrorColor = new Color(.71,.97,.81, 1);
        this.originalColor = new Color(0,.55,.19, 1);
        this.shadowColor = new Color(0,.32,0, 1);
        this.mirror = new CustomRectangle(this.mirrorColor, pixel);
        this.original = new CustomRectangle(this.originalColor, pixel);
        this.shadow = new CustomRectangle(this.shadowColor, pixel);
    }
}
