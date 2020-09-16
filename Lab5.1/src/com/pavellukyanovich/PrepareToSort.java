package com.pavellukyanovich;
import java.util.ArrayList;
import java.util.List;

public class PrepareToSort{


    static List<Details> firstProcessFaster = new ArrayList<>();
    static List<Details> secondProcessFaster = new ArrayList<>();

    public static List<Details> getFirstProcessFaster() {
        return firstProcessFaster;
    }

    public static List<Details> getSecondProcessFaster() {
        return secondProcessFaster;
    }


    public  void minTimeOfProcess(List<Details> list) {

        for (Details d : list) {
            if (d.getTime1() <= d.getTime2()) {firstProcessFaster.add(d);}
            else {
                secondProcessFaster.add(d);
            }
        }
    }
}
