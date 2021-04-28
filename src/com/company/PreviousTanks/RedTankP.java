package com.company.PreviousTanks;

import javafx.scene.paint.Color;

public class RedTankP extends Tank{
    public RedTankP(){
        this.mirrorColor = new Color(1,1,1, 1);
        this.originalColor = new Color(.71,.19,.13, 1);
        this.shadowColor = new Color(.35,0,.48, 1);
        this.mirror = new CustomRectangle(this.mirrorColor, getPixel());
        this.original = new CustomRectangle(this.originalColor, getPixel());
        this.shadow = new CustomRectangle(this.shadowColor, getPixel());
    }
}
