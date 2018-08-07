package com.lu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Leet56 {
    // Definition for an interval.
    public class Interval {
        int start;
        int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return String.format("start:%d, end:%d.", start, end);
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals.size() == 0)
            return result;

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start)
                    return 0;
                return o1.start > o2.start ? 1 : -1;
            }
        });

        for (int i = 0; i < intervals.size(); ) {
            Interval interval = new Interval(intervals.get(i).start, intervals.get(i).end);
            int j = i + 1;
            for (; j < intervals.size(); j++) {
                if (intervals.get(j).start > interval.end)
                    break;
                else {
                    interval.end = Math.max(interval.end, intervals.get(j).end);
                }
            }
            j--;
            result.add(interval);
            i = j + 1;
        }

        return result;
    }

    public void func() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(0, 2));
        intervals.add(new Interval(3, 5));
//        intervals.add(new Interval(15, 18));
        System.out.println(intervals);
        System.out.println(merge(intervals));
    }

    public static void main(String[] args) {
//        List<Interval> intervals = new ArrayList<>();
        Leet56 l56 = new Leet56();
        l56.func();
    }

}
