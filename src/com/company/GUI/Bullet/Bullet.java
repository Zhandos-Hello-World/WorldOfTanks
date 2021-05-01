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
    private boolean canFire = true;
    public Bullet(char goal){
        //for get pixel
        Tank tank = new WhiteTank();
        this.pixel = tank.getPixel();
        black = new CustomRectangle(new Color(0,0,0,1), pixel);
        colorOfTheBullet = new CustomRectangle(new Color(.68,.68,.68, 1), pixel);
        this.goal = goal;
    }
    public void checkBarrier(Map map, int rotate, Position position) throws InvalidMapException {
        this.positionOfTheBullet = position;
        if(rotate == 0 && canFire){
            int endX = map.getSize() * 2 * getPixel() * getSizeWidth();
            for(int i = positionOfTheBullet.getX(); i < map.getSize(); i++){
                if(map.getValueAt(positionOfTheBullet.getY(), i) == 'B' || map.getValueAt(positionOfTheBullet.getY(), i) == this.goal){
                    positionOfTheBullet = new Position(i, positionOfTheBullet.getY());
                    check = true;
                    break;
                }
                else if(map.getValueAt(positionOfTheBullet.getY(), i) == 'S'){
                    check = true;
                    positionOfTheBullet = new Position(i, positionOfTheBullet.getY());
                    break;
                }
            }
            if(check){
                endX = 2 * getSizeWidth() * getPixel() * positionOfTheBullet.getX();
            }
            initializeOnBullet();
            Line line = new Line(position.getX() * 2 * getPixel() * getSizeWidth() + 2 * getSizeWidth(), position.getY() * 2 * getPixel() * getSizeHeight() + (getSizeHeight() * getPixel()), endX, positionOfTheBullet.getY() * 2 * getPixel() * getSizeHeight() + (getSizeHeight() * getPixel()));
            line.setVisible(false);
            PathTransition animationOfTheTank = new PathTransition();
            bullet.setRotate(90);
            int length = position.getX() - position.getX() * 2 * getPixel() * getSizeWidth() + 2 * getSizeWidth();
            animationOfTheTank.setDuration(Duration.millis(400));
            animationOfTheTank.setPath(line);
            animationOfTheTank.setNode(bullet);
            animationOfTheTank.play();
            Map.pane.getChildren().addAll(line, bullet);
            canFire = false;
            System.out.println(positionOfTheBullet.getX() + ", " + positionOfTheBullet.getY());
            animationOfTheTank.setOnFinished(event -> {
                canFire = true;
                bullet.setVisible(false);
                if(check){
                    map.delete(positionOfTheBullet);
                    check = false;
                }
            });
        }
        else if(rotate == 1 && canFire){
            int endX = 0;
            for(int i = positionOfTheBullet.getX(); i >= 0; i--){
                if(map.getValueAt(positionOfTheBullet.getY(), i) == 'B' || map.getValueAt(positionOfTheBullet.getY(), i) == goal){
                    positionOfTheBullet = new Position(i, positionOfTheBullet.getY());
                    check = true;
                    break;
                }
                else if(map.getValueAt(positionOfTheBullet.getY(), i) == 'S'){
                    positionOfTheBullet = new Position(i, positionOfTheBullet.getY());
                    check = true;
                    break;
                }
            }
            if(check && !position.equals(positionOfTheBullet)){
                endX = 2 * getSizeWidth() * getPixel() * positionOfTheBullet.getX() + getSizeWidth();
            }
            initializeOnBullet();
            Line line = new Line(position.getX() * 2 * getPixel() * getSizeWidth() -   getSizeWidth(), position.getY() * 2 * getPixel() * getSizeHeight() + (getSizeHeight() * getPixel()), endX, positionOfTheBullet.getY() * 2 * getPixel() * getSizeHeight() + (getSizeHeight() * getPixel()));
            line.setVisible(false);
            PathTransition animationOfTheTank = new PathTransition();
            animationOfTheTank.setDuration(Duration.millis(400));
            bullet.setRotate(-90);
            animationOfTheTank.setPath(line);
            animationOfTheTank.setNode(bullet);
            animationOfTheTank.play();
            Map.pane.getChildren().addAll(line, bullet);
            canFire = false;
            System.out.println(positionOfTheBullet.getX() + ", " + positionOfTheBullet.getY());
            animationOfTheTank.setOnFinished(event -> {
                canFire = true;
                bullet.setVisible(false);
                if(check && !position.equals(positionOfTheBullet)){
                    map.delete(positionOfTheBullet);
                    check = false;
                }
            });

        }
        else if(rotate == 2 && canFire){
            int endY = 0;
            for(int i = positionOfTheBullet.getY(); i >= 0; i--){
                if(map.getValueAt(i, positionOfTheBullet.getX()) == 'B' || map.getValueAt(i, positionOfTheBullet.getX()) == goal){
                    positionOfTheBullet = new Position(positionOfTheBullet.getX(), i);
                    check = true;
                    break;
                }
                else if(map.getValueAt(i, positionOfTheBullet.getX()) == 'S'){
                    positionOfTheBullet = new Position(positionOfTheBullet.getX(), i);
                    check = true;
                    break;
                }
            }
            if(check && !position.equals(positionOfTheBullet)){
                endY = 2 * getSizeHeight() * getPixel() * positionOfTheBullet.getY() + 2 * (getSizeWidth() * getPixel());
            }
            initializeOnBullet();
            Line line = new Line(position.getX() * 2 * getPixel() * getSizeWidth() + (getSizeWidth() * getPixel()) , position.getY() * 2 * getPixel() * getSizeHeight() - getSizeWidth(), position.getX() * 2 * getPixel() * getSizeWidth() + (getSizeWidth() * getPixel()), endY);
            line.setVisible(false);
            PathTransition animationOfTheTank = new PathTransition();
            animationOfTheTank.setDuration(Duration.millis(400));
            bullet.setRotate(0);
            animationOfTheTank.setPath(line);
            animationOfTheTank.setNode(bullet);
            animationOfTheTank.play();
            Map.pane.getChildren().addAll(line, bullet);
            canFire = false;
            System.out.println(positionOfTheBullet.getX() + ", " + positionOfTheBullet.getY());
            animationOfTheTank.setOnFinished(event -> {
                canFire = true;
                bullet.setVisible(false);
                if(check && !position.equals(positionOfTheBullet)){
                    map.delete(positionOfTheBullet);
                    check = false;
                }
            });
        }
        else if(rotate == 3 && canFire){
            int endY = map.getSize() * 2 * getPixel() * getSizeHeight();
            for(int i = positionOfTheBullet.getY(); i < map.getSize(); i++){
                if(map.getValueAt(i, positionOfTheBullet.getX()) == 'B' || map.getValueAt(i, positionOfTheBullet.getX()) == goal){
                    positionOfTheBullet = new Position(positionOfTheBullet.getX(), i);
                    check = true;
                    break;
                }
                else if(map.getValueAt(i, positionOfTheBullet.getX()) == 'S'){
                    check = true;
                    positionOfTheBullet = new Position(positionOfTheBullet.getX(), i);
                    break;
                }
            }
            if(check ){
                endY = 2 * getSizeHeight() * getPixel() * positionOfTheBullet.getY() -  (getSizeWidth() * getPixel());
            }
            initializeOnBullet();
            Line line = new Line(position.getX() * 2 * getPixel() * getSizeWidth() + (getSizeWidth() * getPixel()) , position.getY() * 2 * getPixel() * getSizeHeight() + getSizeWidth(), position.getX() * 2 * getPixel() * getSizeWidth() + (getSizeWidth() * getPixel()), endY);
            line.setVisible(false);
            PathTransition animationOfTheTank = new PathTransition();
            animationOfTheTank.setDuration(Duration.millis(400));
            bullet.setRotate(180);
            animationOfTheTank.setPath(line);
            animationOfTheTank.setNode(bullet);
            animationOfTheTank.play();
            Map.pane.getChildren().addAll(line, bullet);
            canFire = false;
            System.out.println(positionOfTheBullet.getX() + ", " + positionOfTheBullet.getY());
            animationOfTheTank.setOnFinished(event -> {
                canFire = true;
                bullet.setVisible(false);
                if(check && !position.equals(positionOfTheBullet)){
                    map.delete(positionOfTheBullet);
                    check = false;
                }
            });
        }
    }


    public void initializeOnBullet(){
        bullet =  new GridPane();
        bullet.setVisible(true);
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
