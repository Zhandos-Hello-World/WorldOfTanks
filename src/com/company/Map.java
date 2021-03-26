package com.company;

import java.util.Scanner;

public class Map{
    private int N;
    private char [][]NxN;
    Map(Scanner scanner) throws InvalidMapException{
        boolean checkPosition = false;
        this.N = scanner.nextInt();
        NxN = new char[N][N];
        for(int y = 0; y < getSize(); y++){
            for(int x = 0; x < getSize(); x++){
                char check = scanner.next().charAt(0);
                if(check == '1' || check == '0' || check == 'P'){
                    if(check == 'P'){
                        checkPosition = true;
                    }
                    NxN[y][x] = check;
                }
                else{
                    throw new InvalidMapException();
                }
            }
        }
        //here p is absent
        if(!checkPosition){
            throw new InvalidMapException("Hello p. How are you? Where are you?");
        }

    }
    int getSize(){
        return this.N;
    }

    public char getValueAt(int y, int x) throws InvalidMapException{
        if(x >= NxN.length || y >= NxN.length){
            throw new InvalidMapException();
        }
        return NxN[y][x];
    }
    public void print(){
        for (char[] chars : NxN) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}