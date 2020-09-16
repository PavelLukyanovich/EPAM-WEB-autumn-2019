package monitor;

import settings.Settings;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Monitor {

    private List<Integer> inCross = new ArrayList<>();

    public boolean enterOnCrossRoad(JButton button) {
        if ((inCross.size() > 0)
                && ((Settings.numberTask) || (!inCross.contains(button.getBackground().getRGB())))) {
            try {
                this.wait();
                return false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        inCross.add(button.getBackground().getRGB());
        return true;
    }


    public void leaveCross() {
        inCross.remove(0);
        this.notifyAll();
    }
}

