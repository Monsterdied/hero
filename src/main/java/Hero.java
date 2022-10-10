import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero extends Element{
public Hero(int i,int i2){
    position = new Position(i,i2);
}
public int getX(){
    return position.getX();
}
public int getY(){
    return position.getY();
}
public Position getPosition(){
        return position;
    }public Position moveUp() {
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
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);

        graphics.putString(new TerminalPosition(position.getX(),position.getY()), "X");
    }
}
