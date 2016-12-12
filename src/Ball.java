import javax.swing.*;
/**
 * Created by Ron on 10/10/2016.
 */
public class Ball {
    private int x, y;     // (x,y) position of the top left corner of the ball
    private int diameter;
    private int dx, dy;
    // direction & amount to change when moving, dx for x-axis and dy for y-axis


    public Ball(int startingX, int startingY) {
        x = startingX;
        y = startingY;
        diameter = 20;
        dx = 1;
        dy = 3;

    }

    // return the current x-axis coordinate of the top left corner of the ball
    public int getX() {
        return x;
    }

    // return the current y-axis coordinate of the top left corner of the ball
    public int getY() {
        return y;
    }

    public int getDX() {
        return dx;
    }

    public int getDY() {
        return dy;
    }

    // return the diameter of the ball
    public int getDiameter() {
        return diameter;
    }


    public void bounceX() {
        dx = -dx;
    }

    public void bounceY() {
        dy = -dy;
    }

    // move the ball's center along both axes
    public void move() {
        x += dx;
        y += dy;

    }
}