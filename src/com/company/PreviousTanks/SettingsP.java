package com.company.PreviousTanks;

public interface SettingsP{
    int pixel = 1;
    int sizeHeight = 16;
    int sizeWidth = 16;
    default int getPixel(){
        return pixel;
    }
    default int getSizeHeight(){
        return sizeHeight;
    }
    default int getSizeWidth(){
        return sizeWidth;
    }
}
