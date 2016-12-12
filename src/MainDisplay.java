import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by zacha on 12/11/2016.
 */
public class MainDisplay extends JPanel implements KeyListener  {
    ArrayList<ArrayList<Brick>> bricksArray;
    ArrayList<Ball> ballsOnScreen;
    ArrayList<Paddle> paddles;
    Paddle paddle;

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        for( int i= 0; i < 1; i++) {
            g.fillRect(paddles.get(i).getX(), paddles.get(i).getY(), paddles.get(i).getWidth(), paddles.get(i).getHeight());
        }

        for (int bbb = 0; bbb < 1; bbb++) {
            g.fillOval(ballsOnScreen.get(bbb).getX(), ballsOnScreen.get(bbb).getY(), ballsOnScreen.get(bbb).getDiameter(), ballsOnScreen.get(bbb).getDiameter());
        }

        for (int aaa = 0; aaa < bricksArray.size(); aaa++) {
            for (int bbb = 0; bbb < bricksArray.get(aaa).size(); bbb++) {
                g.fillRect(bricksArray.get(aaa).get(bbb).getX(), bricksArray.get(aaa).get(bbb).getY(), bricksArray.get(aaa).get(bbb).getHeight(), bricksArray.get(aaa).get(bbb).getWidth());
            }
        }
    }

    public void animate() {
        boolean immortal = true;
        for (int bbb = 0; bbb > 100; bbb++) {
            if (ballsOnScreen.get(bbb).getX() + ballsOnScreen.get(bbb).getDX() >= (getWidth() - 20) || ballsOnScreen.get(bbb).getX() + ballsOnScreen.get(bbb).getDX() <= 0) {
                ballsOnScreen.get(bbb).bounceX();
            } else {
                if (ballsOnScreen.get(bbb).getY() + ballsOnScreen.get(bbb).getDY() >= (getHeight() - 20) || immortal && ballsOnScreen.get(bbb).getY() + ballsOnScreen.get(bbb).getDY() <= 0) {
                    ballsOnScreen.get(bbb).bounceY();
                }
            }
            ballsOnScreen.get(bbb).move();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (ballsOnScreen.get(i).getY() == bricksArray.get(0).get(j).getY()) {
                    bricksArray.get(0).remove(j);
                } else {
                    if (ballsOnScreen.get(i).getY() == bricksArray.get(1).get(j).getY()) {
                        bricksArray.get(1).remove(j);
                    } else {
                        if (ballsOnScreen.get(i).getY() == bricksArray.get(2).get(j).getY()) {
                            bricksArray.get(2).remove(j);
                        } else {
                            if (ballsOnScreen.get(i).getY() == bricksArray.get(3).get(j).getY()) {
                                bricksArray.get(3).remove(j);
                            } else {
                                if (ballsOnScreen.get(i).getY() == bricksArray.get(4).get(j).getY()) {
                                    bricksArray.get(4).remove(j);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public MainDisplay() {
        super();

        paddles= new ArrayList<Paddle>();
        for (int i = 0; i < 5; i++) {
            paddles.add(new Paddle(150 + (i* 20), 340 +(i *20)));
        }

        ballsOnScreen = new ArrayList<Ball>();
        for (int bbb = 0; bbb < 5; bbb++) {
            ballsOnScreen.add(new Ball(20 + (bbb * 30), 20 + (bbb + 5)));
        }

        bricksArray = new ArrayList<ArrayList<Brick>>();
        for (int i = 0; i < 5; i++) {
            ArrayList<Brick> currentRow = new ArrayList<>();
            for (int j = 0; j < 16; j++) {
                currentRow.add(new Brick(j * 32, i * 30 + 56, 30, 25));
                System.out.println("Brick(" + j * 32 + " , " + i * 30 + ", 30, 25)");
            }
            bricksArray.add(currentRow);
        }
    }


    public static void main(String[] args) throws Exception {
        JFrame theApp = new JFrame();
        MainDisplay theDisplay = new MainDisplay();

        theApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theApp.setSize(450, 450);                // creates window with width=500 and height=500
        theApp.add(theDisplay);
        theApp.setVisible(true);

        // loop forever (well, until the application is closed anyway)

        while (true) {
            theDisplay.animate();  // originally forgot to invoke this method lol
            theApp.repaint();        // trigger the JPanel paintComponent() method to be called
            Thread.sleep(50);        // go to sleep for 20 milliseconds

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.leftPressed = true;
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                paddle.rightPressed = true;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.rightPressed = false;
        }
    }



            /* go to this website to find out what you need to do for the panel.... it actually looks easier than the
             bricks in all honesty https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
             */

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
