import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private Hero hero = new Hero(10, 10);
    private int width;
    private int height;
    public Arena(int i,int i2){
        width=i;
        height = i2;
    }

    public void processKey(KeyStroke key) {
        System.out.println(key);
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'w'){
            moveHero(hero.moveUp());
        } else if (key.getKeyType() == KeyType.Character && key.getCharacter() == 's') {
            moveHero(hero.moveDown());
        }else if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'a'){
            moveHero(hero.moveLeft());
        } else if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'd') {
            moveHero(hero.moveRight());
        }

    }
    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }
    private boolean canHeroMove(Position position){
        if(position.getX()<width && position.getX()>-1 && position.getY()<height && position.getY()>-1){
            return true;
        }
        return false;
    }
    public void draw(TextGraphics graphics) throws IOException {

            hero.draw(graphics);

    }
}
