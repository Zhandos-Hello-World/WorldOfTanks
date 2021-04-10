package com.company.GUI;

public interface Settings {
    int pixel = 3;
    int sizeHeight = 14;
    int sizeWidth = 13;
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
