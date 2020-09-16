import monitor.Monitor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static settings.Settings.*;

public class CrossRoad {

    private JFrame frame;
    private JButton addHorSquareButton, addVertSquareButton, changeTaskButton, exitButton;
    private MyDrawPanel drawPanel;
    private Monitor monitor = new Monitor();
    private List<Thread> threadList = new ArrayList<>();

    public static class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g){
            g.setColor(Color.white);
            g.fillRect(0,0, FRAME_WIDTH, FRAME_HEIGHT);

            g.setColor(COLOR_OF_LINE);
            g.drawLine(POINT_CROSS_ROAD.x,0, POINT_CROSS_ROAD.x, FRAME_HEIGHT);

            g.setColor(COLOR_OF_LINE);
            g.drawLine(POINT_CROSS_ROAD.x+ DIMENSION_CROSS_ROAD.width,0,
                    POINT_CROSS_ROAD.x+ DIMENSION_CROSS_ROAD.width, FRAME_HEIGHT);

            g.setColor(COLOR_OF_LINE);
            g.drawLine(0, POINT_CROSS_ROAD.y, FRAME_WIDTH, POINT_CROSS_ROAD.y);

            g.setColor(COLOR_OF_LINE);
            g.drawLine(0, POINT_CROSS_ROAD.y+ DIMENSION_CROSS_ROAD.height,
                    FRAME_WIDTH, POINT_CROSS_ROAD.y+ DIMENSION_CROSS_ROAD.height);
        }
    }


    public void go() {

        addHorSquareButton = new JButton("<html><font size=5><p align = center>Добавить горизонтальный квадрат");
        addHorSquareButton.setLocation(10,10);
        addHorSquareButton.setSize(230,230);
        addHorSquareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                threadList.add(new Thread(new ThreadSquare(true, monitor)));
                threadList.get(threadList.size() - 1).start();
            }
        });

        addVertSquareButton = new JButton("<html><font size=5><p align = center>Добавить вертикальный квадрат");
        addVertSquareButton.setLocation(360,10);
        addVertSquareButton.setSize(230,230);
        addVertSquareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                threadList.add(new Thread(new ThreadSquare(false, monitor)));
                threadList.get(threadList.size() - 1).start();
            }
        });

        changeTaskButton = new JButton(BUTTON_TEXT_PART2);
        changeTaskButton.setLocation(10,360);
        changeTaskButton.setSize(230,205);
        changeTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(numberTask) {
                    changeTaskButton.setText(BUTTON_TEXT_PART1);
                    frame.setTitle(FRAME_TEXT_TASK2);
                    numberTask = false;
                }else{
                    changeTaskButton.setText(BUTTON_TEXT_PART2);
                    frame.setTitle(FRAME_TEXT_TASK1);
                    numberTask = true;
                }
            }
        });

        exitButton = new JButton("<html><font size=5>Выход");
        exitButton.setLocation(360,360);
        exitButton.setSize(225,205);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taskStop = true;
                synchronized (monitor) {
                    monitor.notifyAll();
                }
                try {
                    for (Thread thread : threadList) thread.join();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                System.exit(0);
            }
        });

        initDrawPanel();
        initFrame();
    }

    private void initDrawPanel() {
        drawPanel = new MyDrawPanel();
        drawPanel.setBackground(Color.white);
        drawPanel.setLayout(null);
        drawPanel.add(addHorSquareButton);
        drawPanel.add(addVertSquareButton);
        drawPanel.add(changeTaskButton);
        drawPanel.add(exitButton);
        contentPane = drawPanel;
    }

    private void initFrame() {
        frame = new JFrame(FRAME_TEXT_TASK1);
        frame.getContentPane().add(drawPanel, BorderLayout.CENTER);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon(ICON_FILE_NAME).getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        CrossRoad cr = new CrossRoad();
        cr.go();

    }
}

