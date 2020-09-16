package com.pavellukyanovich;

import java.util.List;

public class TimeOfProcess {
    public static int time(List<Details> list) {
        int time = 0;
        for (Details d : list) {
            time += d.time1;
        }
            time += (list.get(list.size() - 1).getTime2());
        return time;
    }
}
