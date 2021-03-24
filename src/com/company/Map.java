package com.company;

import java.util.Scanner;

public class Map{
    private int N;
    private char []NxN;
    Map(Scanner scanner){
        int N = scanner.nextInt();

    }
    int getSize(){
        //doesn't work
        return 0;
    }
    char getValue(int x, int y){
        return ' ';
    }
    void print(){}
}