package com.company.GUI.Tanks;

import javafx.scene.paint.Color;

public class RedTank extends Tank{
    public RedTank(){
        this.mirrorColor = new Color(1,1,1, 1);
        this.originalColor = new Color(.71,.19,.13, 1);
        this.shadowColor = new Color(.35,0,.48, 1);
        this.mirror = new CustomRectangle(this.mirrorColor, pixel);
        this.original = new CustomRectangle(this.originalColor, pixel);
        this.shadow = new CustomRectangle(this.shadowColor, pixel);
    }
}
