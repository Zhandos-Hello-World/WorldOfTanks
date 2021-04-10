package com.company.GUI;

public interface Settings {
    int pixel = 3;
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
