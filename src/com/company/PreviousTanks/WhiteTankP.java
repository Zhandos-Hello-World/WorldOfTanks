package com.company.PreviousTanks;

import javafx.scene.paint.Color;

public class WhiteTankP extends Tank{
    public WhiteTankP(){
        this.mirrorColor = new Color(1,1,1, 1);
        this.originalColor = new Color(.42,.42,.42, 1);
        this.shadowColor = new Color(0,.17,.20, 1);
        this.mirror = new CustomRectangle(this.mirrorColor, getPixel());
        this.original = new CustomRectangle(this.originalColor, getPixel());
        this.shadow = new CustomRectangle(this.shadowColor, getPixel());
    }
}
