package com.pavellukyanovich.comparator;

import com.pavellukyanovich.Details;

import java.util.Comparator;

public class ComparatorTime implements Comparator<Details> {

    @Override
    public int compare(Details o1, Details o2) {
        return o1.getTime1() - o2.getTime1();
    }
}
