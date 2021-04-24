package com.company.offlineTwoPlayers;

import com.company.InvalidMapException;
import com.company.Map;
import com.company.Position;

public class AnotherPlayers {
    protected Map map;
    protected char[][]NxN;
    protected int x = 0;
    protected int y = 0;
    protected static int health = 3;

    public void setMap(Map map) {
        this.map = map;
        map.setHealth(health);
        NxN = new char[map.getSize()][map.getSize()];
        try{
            for(int i = 0; i < map.getSize(); i++){
                for(int j = 0; j < map.getSize(); j++){
                    NxN[i][j] = map.getValueAt(i, j);
                    if(NxN[i][j] == 'Q'){
                        y = i;
                        x = j;
                    }
                }
            }
        }
        catch (InvalidMapException ex){
            System.out.print(ex.getMessage());
        }
    }
    protected void repoint(){
        this.NxN = new char[map.getSize()][map.getSize()];
        try{
            for(int i = 0; i < map.getSize(); i++){
                for(int j = 0; j < map.getSize(); j++){
                    NxN[i][j] = map.getValueAt(i, j);
                    if(NxN[i][j] == 'Q'){
                        this.y = i;
                        this.x = j;
                    }
                }
            }
        }
        catch (InvalidMapException ex){
            System.out.print(ex.getMessage());
        }
    }

    public void moveRight() {
        setMap(map);
        if(((map.getSize() > x + 1) && (NxN[y][x + 1] == '0' || NxN[y][x + 1] == 'T'))){
            System.out.println("Right");
            if(NxN[y][x + 1] == '0'){
                NxN[y][x] = '0';
                x += 1;
                NxN[y][x] = 'Q';
                map.setCurrentPositionAnother(new Position(x, y));
                setMap(map);
            }
            else if(NxN[y][x + 1] == 'T'){
                NxN[y][x] = '0';
                x += 1;
                NxN[y][x] = 'T';
                map.setCurrentPositionAnother(new Position(x, y));
                setMap(map);
            }
        }
        else{
            System.out.println("Invalid position!");
        }
    }

    public void moveLeft() {
        setMap(map);
        if(!(-1 == x - 1) && (NxN[y][x - 1] == '0' || NxN[y][x - 1] == 'T')){
            System.out.println("Left");
            if(NxN[y][x - 1] == '0'){
                NxN[y][x] = '0';
                x -= 1;
                NxN[y][x] = 'Q';
                map.setCurrentPositionAnother(new Position(x, y));
                setMap(map);
            }
            else if(NxN[y][x - 1] == 'T'){
                NxN[y][x] = '0';
                x -= 1;
                NxN[y][x] = 'T';
                map.setCurrentPositionAnother(new Position(x, y));
                setMap(map);
            }
        }
        else{
            System.out.println("Invalid position!");
        }
    }

    public void moveUp() {
        setMap(map);
        if(!(-1 == y - 1) && (NxN[y - 1][x] == '0' || NxN[y - 1][x] == 'T')) {
            System.out.println("Up");
            if(NxN[y - 1][x] == '0'){
                NxN[y][x] = '0';
                y -= 1;
                NxN[y][x] = 'Q';
                map.setCurrentPositionAnother(new Position(x, y));
                setMap(map);
            }
            else if(NxN[y - 1][x] == 'T'){
                NxN[y][x] = '0';
                y -= 1;
                NxN[y][x] = 'T';
                map.setCurrentPositionAnother(new Position(x, y));
                setMap(map);
            }
        }
        else{
            System.out.println("Invalid position!");
        }
    }

    public void moveDown() {
        setMap(map);
        if((map.getSize() > y + 1) && (NxN[y + 1][x] == '0' || NxN[y + 1][x] == 'T')){
            System.out.println("Down");
            if (NxN[y + 1][x] == '0') {
                NxN[y][x] = '0';
                y += 1;
                NxN[y][x] = 'Q';
                map.setCurrentPositionAnother(new Position(x, y));
                setMap(map);
            }
            else if(NxN[y + 1][x] == 'T'){
                NxN[y][x] = '0';
                y += 1;
                NxN[y][x] = 'T';
                map.setCurrentPositionAnother(new Position(x, y));
                setMap(map);
            }
        }
        else{
            System.out.println("Invalid Position!");
        }
    }
    public Position getPosition() {
        return new Position(x, y);
    }
}
