import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    private Hero hero = new Hero(10, 10);
    private int width;
    private int height;
    public Arena(int i,int i2){

        width=i;
        height = i2;
        this.walls = createWalls();
        coins =createCoins();
        monsters = createMonsters();
    }
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }
    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return monsters;
    }
    private void moveMonsters(){
        for (Monster monster : monsters){
            monster.move();
            while(!(monster.getPosition().getX()<(width-1) && monster.getPosition().getX()>0 && monster.getPosition().getY()<(height-1) && monster.getPosition().getY()>0)){
                monster.move();
            }
        }
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
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
        for(Wall wall :walls){
            if(wall.getPosition().equals(position)) return false;
        }
        return true;
    }
    private void retrieveCoins(Coin coin){
        coins.remove(coin);
    }

    public void draw(TextGraphics graphics) throws IOException {
        int check = 1;
        Coin remove_c = null;
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Coin coin : coins){
            coin.draw(graphics);
            if(coin.getPosition().equals(hero.getPosition())){
                check= 0;
                remove_c = coin;
            }
        }
        if(check==0){retrieveCoins(remove_c);
        check=1;}
        moveMonsters();
        for (Monster monster : monsters){
            monster.draw(graphics);
            if(monster.getPosition().equals(hero.getPosition())){
                System.out.println("Game over");
                System.exit(0);
            }
        }
        hero.draw(graphics);

    }

}
