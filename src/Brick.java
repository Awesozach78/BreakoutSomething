/**
 * Created by Z on 10/25/2016.
 */
public class Brick{
    private int brickx, bricky;
    private int brickHeight;
    private int brickWidth;
    public Brick (int startx, int starty, int Height, int Width) {
        brickx = startx;
        bricky = starty;
        brickHeight = Height;
        brickWidth = Width;

    }

    public int getX() {return brickx; }
    public int getY() {return bricky;}
    public int getHeight() {return brickHeight;}
    public int getWidth() {return brickWidth;}
}