import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class  Element {
    protected Position position;
    public abstract void draw(TextGraphics graphics);

}
