package com.company.PreviousTanks;

import javafx.scene.paint.Color;

public class RedPreviousTankP extends PreviousTank {
    public RedPreviousTankP(){
        this.mirrorColor = new Color(1,1,1, 1);
        this.originalColor = new Color(.71,.19,.13, 1);
        this.shadowColor = new Color(.35,0,.48, 1);
        this.mirror = new CustomRectanglePrevious(this.mirrorColor, getPixel());
        this.original = new CustomRectanglePrevious(this.originalColor, getPixel());
        this.shadow = new CustomRectanglePrevious(this.shadowColor, getPixel());
    }
}
