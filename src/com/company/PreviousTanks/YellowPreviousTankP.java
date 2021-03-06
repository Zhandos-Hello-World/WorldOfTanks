package com.company.PreviousTanks;

import javafx.scene.paint.Color;

public class YellowPreviousTankP extends PreviousTank {
    public YellowPreviousTankP(){
        this.mirrorColor = new Color(.91,.91,.58, 1);
        this.originalColor = new Color(.91,.61,.13, 1);
        this.shadowColor = new Color(.42,.42,0, 1);
        this.mirror = new CustomRectanglePrevious(this.mirrorColor, getPixel());
        this.original = new CustomRectanglePrevious(this.originalColor, getPixel());
        this.shadow = new CustomRectanglePrevious(this.shadowColor, getPixel());
    }
}
