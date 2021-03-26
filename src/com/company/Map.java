package com.company;


import java.util.Scanner;

public class Map{
    private int N;
    private char [][]NxN;
    Map(Scanner scanner){
        this.N = scanner.nextInt();
        NxN = new char[N][N];
        for(int x = 0; x < getSize(); x++){
            for(int y = 0; y < getSize(); y++){
                NxN[x][y] = scanner.next().charAt(0);
            }
        }
    }
    int getSize(){
        return this.N;
    }
    char getValue(int x, int y) throws InvalidMapException{
        if(x >= N || y >= N){
            throw new InvalidMapException();
        }
        return this.NxN[x][y];
    }

    public char getValueAt(int x, int y){
        return NxN[x][y];
    }
    public void print(){
        for(int i = 0; i < NxN.length; i++){
            for(int j = 0; j < NxN[i].length; j++){
                System.out.print(NxN[i][j]);
            }
            System.out.println();
        }
    }
}