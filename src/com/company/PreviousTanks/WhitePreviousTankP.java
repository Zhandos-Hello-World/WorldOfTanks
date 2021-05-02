package com.company.PreviousTanks;

import javafx.scene.paint.Color;

public class WhitePreviousTankP extends PreviousTank {
    public WhitePreviousTankP(){
        this.mirrorColor = new Color(1,1,1, 1);
        this.originalColor = new Color(.42,.42,.42, 1);
        this.shadowColor = new Color(0,.17,.20, 1);
        this.mirror = new CustomRectanglePrevious(this.mirrorColor, getPixel());
        this.original = new CustomRectanglePrevious(this.originalColor, getPixel());
        this.shadow = new CustomRectanglePrevious(this.shadowColor, getPixel());
    }
}
