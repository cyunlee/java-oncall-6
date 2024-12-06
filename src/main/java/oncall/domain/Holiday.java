package oncall.domain;

import java.util.Arrays;

public enum Holiday {
    NEW_YEAR(1,1),
    MARCH_FIRST(3,1),
    CHILDREN_DAY(5,5),
    JUNE_SIXTH(6,6),
    AUG_FIFTEENTH(8, 15),
    OCT_THIRD(10,3),
    HANGUL_DAY(10,9),
    CHRISTMAS(12,25);
    private int month;
    private int day;

    Holiday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isTodayHoliday(int month, int day) {
        Holiday holiday = Arrays.stream(values()).filter(value -> value.month == month && value.day == day).findAny().orElse(null);
        if (holiday != null) {
            return true;
        }
        return false;
    }
}
