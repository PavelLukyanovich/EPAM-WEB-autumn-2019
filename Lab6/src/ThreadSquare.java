import monitor.Monitor;
import settings.Settings;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static settings.Settings.*;

public class ThreadSquare implements Runnable {
    private final boolean horVert;
    public int x, y, lastX, lastY;
    private int direction = 1;
    JButton button;
    private final Container contentPane;
    private boolean onCross = false;
    private Monitor monitor;

    public ThreadSquare(boolean horVert, Monitor monitor) {
        this.monitor = monitor;
        this.horVert = horVert;
        if (horVert) {
            x = 0;
            y = POINT_CROSS_ROAD.y + (int) (Math.random() * (DIMENSION_CROSS_ROAD.height - HEIGHT_SQUARE));
        } else {
            x = POINT_CROSS_ROAD.x + (int) (Math.random() * (DIMENSION_CROSS_ROAD.width - WIDTH_SQUARE));
            y = 0;
        }
        this.contentPane = Settings.contentPane;
        initButton();
    }

    @Override
    public void run() {
        while (!taskStop) {
            move();
            getNextPoint();
            synchronized (monitor) {
                if ((isCross()) && (!onCross)) {
                    if (!monitor.enterOnCrossRoad(button)) {
                        x = lastX;
                        y = lastY;
                    }
                }
                if ((!isCross()) && (onCross)) {
                    monitor.leaveCross();

                }
            }
            onCross = isCross();
        }
    }

    private boolean isCross() {
        if (horVert) {
            if ((x > POINT_CROSS_ROAD.x - WIDTH_SQUARE) && (x < (POINT_CROSS_ROAD.x + DIMENSION_CROSS_ROAD.width)))
                return true;
        } else {
            if ((y > POINT_CROSS_ROAD.y - HEIGHT_SQUARE) && (y < (POINT_CROSS_ROAD.y + DIMENSION_CROSS_ROAD.height)))
                return true;
        }
        return false;
    }

    private void getNextPoint() {
        lastX = x;
        lastY = y;
        if (horVert) {
            x += STEP_SQUARE * direction;
            if (x >= FRAME_WIDTH - WIDTH_SQUARE) {
                direction = -1;
            }
            if (x <= 0) {
                direction = 1;
            }
        } else {
            y += STEP_SQUARE * direction;
            if (y >= FRAME_HEIGHT - HEIGHT_SQUARE - 24) {
                direction = -1;
            }
            if (y <= 0) {
                direction = 1;
            }
        }
    }

    private void move() {

        button.setBounds(x, y, WIDTH_SQUARE, HEIGHT_SQUARE);
        try {
            Thread.sleep(DELAY_SQUARE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void initButton(){
        Random random = new Random();
        Color[] color = {new Color(0,0,0), new Color(255,0,0), new Color(0,255,0),new Color(255,165,122),
                new Color(255,215,0),new Color(0,0,255),new Color(255,0,255),new Color(190,190,190)};
        button = new JButton("" + (++counter));
        button.setLocation(x,y);
        button.setSize(WIDTH_SQUARE, HEIGHT_SQUARE);
        button.setMargin(new Insets(0,0,0,0));
        button.setForeground(COLOR_TEXT_SQUARE);
        button.setBackground(color[random.nextInt(color.length)]);
        contentPane.add(button);
    }
}
