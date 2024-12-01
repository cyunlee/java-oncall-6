package oncall.domain;

import java.time.LocalDate;

public enum Holiday {
    JAN(1,1),
    MAR(3,1),
    MAY(5,5),
    JUN(6,6),
    AUG(8,15),
    OCT1(10,3),
    OCT2(10,9),
    DEC(12,25);

    private int month;
    private int day;

    Holiday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
