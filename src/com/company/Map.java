package com.company;

import java.util.Scanner;

public class Map{
    private int N;
    private char [][]NxN;
    Map(Scanner scanner){
        this.N = scanner.nextInt();
        NxN = new char[N][N];
        for(int i = 0; i < getSize(); i++){
            for(int j = 0; j < getSize(); j++){
                NxN[i][j] = scanner.next().charAt(0);
                if(NxN[i][j] == 'P' || NxN[i][j] == 'p'){
                    Position position = new Position(j, i);
                }
            }
        }
        scanner.nextLine();
        String move = scanner.next().toUpperCase();
        for(int i = 0; i < move.length(); i++){
            switch (move.charAt(i)){
                case 'R':break;
                case 'L':break;
                case 'D':break;
                case 'U':break;

            }
        }
    }
    int getSize(){
        return N;
    }
    char getValue(int x, int y) throws InvalidMapException{
        if(x >= N || y >= N){
            throw new InvalidMapException();
        }
        return NxN[y][x];
    }
    void print(){}
}