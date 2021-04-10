package com.company;

abstract public class MyPlayer implements Player{
    private Map map;
    private char[][]NxN;
    private int x = 0;
    private int y = 0;
    @Override
    public void setMap(Map map) {
        this.map = map;
        NxN = new char[map.getSize()][map.getSize()];
        try{
            for(int i = 0; i < map.getSize(); i++){
                for(int j = 0; j < map.getSize(); j++){
                    NxN[i][j] = map.getValueAt(i, j);
                    if(NxN[i][j] == 'P'){
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

    @Override
    public void moveRight() {
        if(!(map.getSize() == x + 1) && !(NxN[y][x + 1] == '1')){
            NxN[y][x] = '0';
            x += 1;
            NxN[y][x] = 'P';
        }

    }

    @Override
    public void moveLeft() {
        if(!(-1 == x - 1) && !(NxN[y][x - 1] == '1')){
            NxN[y][x] = '0';
            x -= 1;
            NxN[y][x] = 'P';
        }
    }

    @Override
    public void moveUp() {
        if(!(-1 == y - 1) && !(NxN[y - 1][x] == '1')){
            NxN[y][x] = '0';
            y -= 1;
            NxN[y][x] = 'P';
        }
    }

    @Override
    public void moveDown() {
        if(!(map.getSize() == y + 1) && !(NxN[y + 1][x] == '1')){
            NxN[y][x] = '0';
            y += 1;
            NxN[y][x] = 'P';
        }
    }

    @Override
    public Position getPosition() {
        return new Position(x, y);
    }
}
