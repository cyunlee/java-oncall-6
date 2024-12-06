package oncall.domain;

import java.util.Arrays;

public enum Month {
    JAN(1,31),
    FEB(2, 28),
    MAR(3, 31),
    APR(4,30),
    MAY(5,31),
    JUN(6,30),
    JUL(7,31),
    AUG(8,31),
    SEP(9,30),
    OCT(10,31),
    NOV(11,30),
    DEC(12,31);

    private final int month;
    private final int lastDay;

    Month(int month, int lastDay) {
        this.month = month;
        this.lastDay = lastDay;
    }

    public static Month findMonth(int month) {
        return Arrays.stream(values()).filter(value -> value.month==month).findAny().orElse(null);
    }

    public int getLastDay() {
        return lastDay;
    }
}
