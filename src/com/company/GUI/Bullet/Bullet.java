package com.company.GUI.Bullet;
import com.company.GUI.Barier.Barrier;
import com.company.GUI.Barier.Null;
import com.company.GUI.Settings;
import com.company.GUI.Tanks.CustomRectangle;
import com.company.GUI.Tanks.Tank;
import com.company.GUI.Tanks.WhiteTank;
import com.company.InvalidMapException;
import com.company.Map;
import com.company.Position;
import javafx.animation.PathTransition;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
public class Bullet implements Settings {
    CustomRectangle black;
    CustomRectangle colorOfTheBullet;
    int pixel;
    private Position positionOfTheBullet;
    private static boolean check = false;
    private char goal;
    private GridPane bullet;
    private Barrier n = new Null();
    public Bullet(char goal){
        //for get pixel
        Tank tank = new WhiteTank();
        this.pixel = tank.getPixel();
        black = new CustomRectangle(new Color(0,0,0,1), pixel);
        colorOfTheBullet = new CustomRectangle(new Color(.68,.68,.68, 1), pixel);
        this.goal = goal;
    }
    public boolean checkBarrier(Map map, int rotate, Position position) throws InvalidMapException {
        this.positionOfTheBullet = position;
        if(rotate == 0){
            int endX = map.getSize() * 2 * getPixel() * getSizeWidth();
            int index = 0;
            for(int i = positionOfTheBullet.getX(); i < map.getSize(); i++){
                if(map.getValueAt(positionOfTheBullet.getY(), i) == 'B' || map.getValueAt(positionOfTheBullet.getY(), i) == this.goal){
                    positionOfTheBullet = new Position(i, positionOfTheBullet.getY());
                    check = true;
                    index = i;
                    break;
                }
                else if(map.getValueAt(positionOfTheBullet.getY(), i) == 'S'){
                    check = false;
                    index = i;
                    break;
                }
            }
            if(check){
                endX = 2 * getSizeWidth() * getPixel() * positionOfTheBullet.getX();
            }
            initializeOnBullet();
            System.out.println(positionOfTheBullet.getX() * 2 * getPixel() * getSizeWidth());
            System.out.println(endX);
            System.out.println();
            Line line = new Line(position.getX() * 2 * getPixel() * getSizeWidth(), position.getY() * 2 * getPixel() * getSizeHeight() + (getSizeHeight() * getPixel()), endX, positionOfTheBullet.getY() * 2 * getPixel() * getSizeHeight() + (getSizeHeight() * getPixel()));
            line.setVisible(false);
            PathTransition animationOfTheTank = new PathTransition();
            Rectangle rectangle = new Rectangle(0, 0, 5, 5);
            rectangle.setFill(Color.ORANGE);
            bullet.setRotate(90);
            animationOfTheTank.setDuration(Duration.millis(400));
            animationOfTheTank.setPath(line);
            animationOfTheTank.setNode(bullet);
            animationOfTheTank.play();
            Map.pane.getChildren().addAll(line, bullet);
            animationOfTheTank.setOnFinished(event -> {
                Map.pane.getChildren().remove(bullet);
                bullet.setGridLinesVisible(false);
                bullet.setVisible(false);
            });
        }
        else if(rotate == 1){
            for(int i = positionOfTheBullet.getX(); i >= 0; i--){
                if(map.getValueAt(positionOfTheBullet.getY(), i) == 'B' || map.getValueAt(positionOfTheBullet.getY(), i) == goal){
                    positionOfTheBullet = new Position(i, positionOfTheBullet.getY());
                    check = true;
                    break;
                }
                else if(map.getValueAt(positionOfTheBullet.getY(), i) == 'S'){
                    check = false;
                    break;
                }
            }
        }
        else if(rotate == 2){
            for(int i = positionOfTheBullet.getY(); i >= 0; i--){
                if(map.getValueAt(i, positionOfTheBullet.getX()) == 'B' || map.getValueAt(i, positionOfTheBullet.getX()) == goal){
                    positionOfTheBullet = new Position(positionOfTheBullet.getX(), i);
                    check = true;
                    break;
                }
                else if(map.getValueAt(i, positionOfTheBullet.getX()) == 'S'){
                    check = false;
                    break;
                }
            }

        }
        else if(rotate == 3){
            for(int i = positionOfTheBullet.getY(); i < map.getSize(); i++){
                if(map.getValueAt(i, positionOfTheBullet.getX()) == 'B' || map.getValueAt(i, positionOfTheBullet.getX()) == goal){
                    positionOfTheBullet = new Position(positionOfTheBullet.getX(), i);
                    check = true;
                    break;
                }
                else if(map.getValueAt(i, positionOfTheBullet.getX()) == 'S'){
                    check = false;
                    break;
                }
            }
        }
        else{
            check = false;
        }
        return check;
    }
    public Position getDelete(Map map, int rotate, Position position) throws InvalidMapException {
        if(!checkBarrier(map, rotate, position)){
            throw new InvalidMapException();
        }
        else{
            check = false;
            return positionOfTheBullet;
        }
    }


    public void initializeOnBullet(){
        bullet =  new GridPane();
        for(int i = 0; i < 14; i++){
            for(int j = 0; j < 13; j++){
                if(i < 3){
                    if(j == 7){
                        bullet.add(colorOfTheBullet.get(), j, i);
                    }
                    else{
                    }
                }
                else if(i >= 3 && i <= 9){
                    if(j >= 6 && j <= 8){
                        bullet.add(colorOfTheBullet.get(), j, i);
                    }
                    else{
                    }
                }
                else{
                }
            }
        }
    }
}
