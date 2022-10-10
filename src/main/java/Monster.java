import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element{
    public Monster(int i ,int i2){
        position = new Position(i,i2);
    }
    public Position getPosition(){
        return position;
    }
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#800080"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(),position.getY()), "0");
    }
    public void move() {
        Random random = new Random();
        int check = random.nextInt(4);
        if (check == 0) position.setX(position.getX()+1);
        if (check == 1) position.setX(position.getX()-1);
        if (check == 2) position.setY(position.getY()+1);
        if (check == 3) position.setY(position.getY()-1);
    }
}
