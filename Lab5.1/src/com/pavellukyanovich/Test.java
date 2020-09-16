package com.pavellukyanovich;

import com.pavellukyanovich.comparator.ComparatorTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.pavellukyanovich.PrepareToSort.*;

public class Test {
    public static void main(String[] args) {
//         Details detail1 = new Details("det1", 1, 5);
//         Details detail2 = new Details("det2", 6, 4);
//         Details detail3 = new Details("det3", 2, 3);
//         Details detail4 = new Details("det4", 6, 3);
//         Details detail5 = new Details("det5", 9, 1);
//         Details detail6 = new Details("det6", 4, 5);
//         Details detail7 = new Details("det7", 2, 2);
//         Details detail8 = new Details("det8", 7, 7);

//        Details detail1 = new Details("det1", 12, 2);
//        Details detail2 = new Details("det2", 7, 9);
//        Details detail3 = new Details("det3", 3, 4);
//        Details detail4 = new Details("det4", 5, 5);
//        Details detail5 = new Details("det5", 1, 3);
//        Details detail6 = new Details("det6", 7, 5);
//        Details detail7 = new Details("det7", 2, 8);

        Details detail1 = new Details("det1", 6, 2);
        Details detail2 = new Details("det2", 3, 4);
        Details detail3 = new Details("det3", 2, 2);
        Details detail4 = new Details("det4", 3, 2);

         Details[] det = {detail1, detail2, detail3, detail4,/* detail5, detail6, detail7, detail8**/};

         List<Details> noSortList = new ArrayList<>(Arrays.asList(det));
         List<Details> sortedList = new ArrayList<>();

         PrepareToSort prepare = new PrepareToSort();
        prepare.minTimeOfProcess(noSortList);

        ComparatorTime comp = new ComparatorTime();

        Collections.sort(getFirstProcessFaster(),comp);
        Collections.sort(getSecondProcessFaster(),comp);

        sortedList.addAll(getFirstProcessFaster());
        sortedList.addAll(getSecondProcessFaster());

        TimeOfProcess time = new TimeOfProcess();

        System.out.println(sortedList);
        System.out.println(time.time(sortedList));


        }
    }
