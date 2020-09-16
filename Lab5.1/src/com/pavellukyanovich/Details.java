package com.pavellukyanovich;

public class Details {
     String name;
     int time1;
     int time2;

    public Details(String name, int t1, int t2) {
        this.name = name;
        this.time1 = t1;
        this.time2 = t2;
    }

    public int getTime1() {
        return time1;
    }

    public int getTime2() {
        return time2;
    }

    @Override
    public String toString() {
        return name + "-" + time1 + "::" + time2;
    }

}
