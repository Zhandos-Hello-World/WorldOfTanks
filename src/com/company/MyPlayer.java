package com.company;

abstract public class MyPlayer implements Player{
    protected Map map;
    protected char[][]NxN;
    protected int x = 0;
    protected int y = 0;
    protected static int health = 3;
    @Override
    public void setMap(Map map) {
        this.map = map;
        map.setHealth(health);
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
    protected void repoint(){
        this.NxN = new char[map.getSize()][map.getSize()];
        try{
            for(int i = 0; i < map.getSize(); i++){
                for(int j = 0; j < map.getSize(); j++){
                    NxN[i][j] = map.getValueAt(i, j);
                    if(NxN[i][j] == 'P'){
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

    @Override
    public void moveRight() {
        if(!(map.getSize() == x + 1) && (NxN[y][x + 1] == '0')){
            NxN[y][x] = '0';
            x += 1;
            NxN[y][x] = 'P';
            map.setCurrentPosition(new Position(x, y));
        }
    }

    @Override
    public void moveLeft() {
        if(!(-1 == x - 1) && (NxN[y][x - 1] == '0')){
            NxN[y][x] = '0';
            x -= 1;
            NxN[y][x] = 'P';
            map.setCurrentPosition(new Position(x, y));
        }
    }

    @Override
    public void moveUp() {
        if(!(-1 == y - 1) && (NxN[y - 1][x] == '0')) {
            NxN[y][x] = '0';
            y -= 1;
            NxN[y][x] = 'P';
            map.setCurrentPosition(new Position(x, y));
        }
    }

    @Override
    public void moveDown() {
        if(!(map.getSize() == y + 1) && (NxN[y + 1][x] == '0')){
            NxN[y][x] = '0';
            y += 1;
            NxN[y][x] = 'P';
            map.setCurrentPosition(new Position(x, y));
        }
    }

    @Override
    public Position getPosition() {
        return new Position(x, y);
    }
}
