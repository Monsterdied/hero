import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero {
    private Position position;
public Hero(int i,int i2){
    position = new Position(i,i2);
}
public int getX(){
    return position.getX();
}
public int getY(){
    return position.getY();
}
    public Position moveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }
    public Position moveDown() {
        return new Position(position.getX(), position.getY() + 1);
    }
    public Position moveRight() {
        return new Position(position.getX()+1, position.getY());
    }
    public Position moveLeft() {
        return new Position(position.getX()-1, position.getY());
    }
    public void setPosition(Position position){
    this.position.setY(position.getY());
    this.position.setX(position.getX());
    }
    public void draw(TextGraphics graphics)throws IOException {
        graphics.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('X')[0]);
    }
}
