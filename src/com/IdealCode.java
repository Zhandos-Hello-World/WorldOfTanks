package com.company;
import java.util.Scanner;
class MyPlayer implements Player{
    private Map mapPlayer;
    private Position position;
    @Override
    public void setMap(Map map) {
        mapPlayer = map;
        locationP();
    }
    private void locationP(){
        for(int i = 0; i < mapPlayer.getSize(); i++){
            for(int j = 0; j < mapPlayer.getSize(); j++){
                if(mapPlayer.getValueAt(i, j) == 'P'){
                    position = new Position(j, i);
                    break;
                }
            }
        }
    }
    @Override
    public void moveRight() {
        if((position.getX() + 1) != mapPlayer.getSize()){
            if(mapPlayer.getValueAt(position.getY(), position.getX() + 1) == '0' ||
                    mapPlayer.getValueAt(position.getY(), position.getX() + 1) == 'P'){
                position.setX(position.getX() + 1);
            }
        }
    }

    @Override
    public void moveLeft() {
        if((position.getX() - 1) >= 0){
            if(mapPlayer.getValueAt(position.getY(), position.getX() - 1) == '0'||
                    mapPlayer.getValueAt(position.getY(), position.getX() - 1) == 'P'){
                position.setX(position.getX() - 1);
            }
        }
    }

    @Override
    public void moveUp() {
        if((position.getY() - 1) >= 0){
            if(mapPlayer.getValueAt(position.getY() - 1, position.getX()) == '0'||
                    mapPlayer.getValueAt(position.getY() - 1, position.getX()) == 'P'){
                position.setY(position.getY() - 1);
            }
        }
    }

    @Override
    public void moveDown() {
        if((position.getY() + 1) != mapPlayer.getSize()||
                mapPlayer.getValueAt(position.getY() + 1, position.getX()) == 'P'){
            if(mapPlayer.getValueAt(position.getY() + 1, position.getX()) == '0'){
                position.setY(position.getY() + 1);
            }
        }
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
class Map{
    private char[][] placeForTank;
    private int size;
    Map(Scanner scanner) throws InvalidMapException{
        size = scanner.nextInt();
        scanner.nextLine();
        if(size > 0){
            placeForTank = new char[getSize()][getSize()];
            for(int i = 0; i < getSize(); i++){
                for(int j = 0; j < getSize(); j++){
                    char valueOfTheIndex = scanner.next().charAt(0);
                    if(!checkSizeInput(valueOfTheIndex)){
                        throw new InvalidMapException("Not enough map elements");
                    }
                    else{
                        placeForTank[i][j] = valueOfTheIndex;
                    }
                }
            }

        }
        else if(size == 0){
            throw new InvalidMapException("Map size can not be zero");
        }
        else{
            throw new InvalidMapException("Map size can not be negative");
        }
    }
    private boolean checkSizeInput(char a){
        return a == 'P' || a == '0' || a == '1';
    }
    public int getSize(){
        return size;
    }
    public char getValueAt(int y, int x){
        return placeForTank[y][x];

    }
    public void print(){
        for(char[]values:placeForTank){
            for(char value:values){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
class Position{
    private int x, y;
    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean equals(Position position){
        return position.toString().equals(position.toString());
    }
    @Override
    public String toString(){
        return "(" +  getX() + "," + getY()  + ")";
    }

}
class InvalidMapException extends Exception{
    private String s;
    public InvalidMapException(String s){
        super(s);
        this.s = s;
    }
    public InvalidMapException(Exception e) {
        e.printStackTrace();
    }
    @Override
    public String toString() {
        return "InvalidMapException{" +
                "message='" + s + '\'' +
                '}';
    }

}
class Game{
    private Map mapGame;
    private MyPlayer myPlayerGame;
    public Game(Map map){
        setMap(map);
    }
    public void setMap(Map map) {
        this.mapGame = map;
    }
    public void addPlayer(Player player){
        this.myPlayerGame = (MyPlayer)player;
        this.myPlayerGame.setMap(mapGame);
    }
}
interface Player{
    public void setMap(Map map);
    public void moveRight();
    public void moveLeft();
    public void moveUp();
    public void moveDown();
    public Position getPosition();
}
/*
Enter your code here.
Create all the necessary classes and methods as per the requirements.
*/
/*
DO NOT MODIFY THIS PART!!!
Input and Output has been done for you.
Various conditions are meant to check individual classes separately.
You still need to implement completely all the necessary classes with their corresponding methods,
but the correctness for each class is checked individually.
In other words, you already get some partial points
for implementing some classes completely and correctly,
even if other classes are complete but still may not work properly.
*/
public class Main{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String className = input.nextLine();

        // Checking the implementation of the Position class
        if(className.equals("Position")){
            Position p1 = new Position(input.nextInt(), input.nextInt());
            System.out.println(p1);
            p1.setX(5);
            System.out.println(p1.getX());

            Position p2 = new Position(5, 10);
            System.out.println(p1.equals(p2));
        }

        // Checking the implementation of the Map class
        else if(className.equals("Map")){
            try{
                Map map = new Map(input);
                map.print();
                int size = map.getSize();
                System.out.println(size);
                System.out.println(map.getValueAt(size/2, size/2));
            }
            catch(Exception e){}
        }

        // Checking the Player interface and the MyPlayer class
        else if(className.equals("Player")){
            Player player = new MyPlayer();
            System.out.println(Player.class.isInterface());
            System.out.println(player instanceof Player);
            System.out.println(player instanceof MyPlayer);
        }

        // Checking the InvalidMapException class
        else if(className.equals("Exception")){
            try{
                throw new InvalidMapException("Some message");
            }
            catch(InvalidMapException e){
                System.out.println(e.getMessage());
            }
        }

        // Checking the Game class and all of its components
        else if(className.equals("Game")){

            // Initialize player, map, and the game
            Player player = new MyPlayer();
            Game game = null;

            try{
                game = new Game(new Map(input));
            }
            catch(InvalidMapException e){ // custom exception
                System.out.println(e.getMessage());
                System.exit(0);
            }

            game.addPlayer(player);

            // Make the player move based on the commands given in the input
            String moves = input.next();
            char move;
            for(int i=0; i<moves.length(); i++){
                move = moves.charAt(i);
                switch(move){
                    case 'R':
                        player.moveRight();
                        break;
                    case 'L':
                        player.moveLeft();
                        break;
                    case 'U':
                        player.moveUp();
                        break;
                    case 'D':
                        player.moveDown();
                        break;
                }
            }

            // Determine the final position of the player after completing all the moves above
            Position playerPosition = player.getPosition();
            System.out.println("Player final position");
            System.out.println("Row: " + playerPosition.getY());
            System.out.println("Col: " + playerPosition.getX());
        }
    }
}
