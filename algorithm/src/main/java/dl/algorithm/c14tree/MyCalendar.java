package dl.algorithm.c14tree;

import java.util.Set;
import java.util.TreeSet;

public class MyCalendar {
    class Period implements Comparable<Period> {
        int start;
        int end;

        public Period(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Period o) {
            if (end <= o.start) {
                return -1;
            }
            if (start >= o.end) {
                return 1;
            }
            return 0;
        }
    }

    private final Set<Period> booked;

    public MyCalendar() {
        this.booked = new TreeSet<>();
    }

    public boolean book(int start, int end) {
        Period scheduler = new Period(start, end);
        return booked.add(scheduler);
    }

}
