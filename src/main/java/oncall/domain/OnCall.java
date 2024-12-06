package oncall.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OnCall {
    private final static List<String> dates = Arrays.asList("월", "화", "수", "목", "금", "토", "일");
    private int month;
    private String startDate;

    public OnCall(int month, String startDate) {
        this.month = month;
        this.startDate = startDate;
    }

    //만약 시작요일이 금요일이면? 2일은 토요일, 3일은 일요일...

    public boolean isTodayWeekday(int day) {
        int dateValue = 0;
        Map<Integer, Integer> calendar = castDatesToDays();
        for (Entry<Integer, Integer> entry : calendar.entrySet()) {
            if (entry.getKey()==day) {
                dateValue = entry.getValue();
            }
        }
        if (dateValue == 1 || dateValue == 2 || dateValue == 3 || dateValue == 4 || dateValue == 5) {
            return true;
        }
        return false;
    }

    public boolean isTodayWeekend(int day) {
        int dateValue = 0;
        Map<Integer, Integer> calendar = castDatesToDays();
        for (Entry<Integer, Integer> entry : calendar.entrySet()) {
            if (entry.getKey()==day) {
                dateValue = entry.getValue();
            }
        }
        if (dateValue == 6 || dateValue == 7) {
            return true;
        }
        return false;
    }

    private int calculateStartDateIdx() {
        int dateIdx = 1;
        for (int i=1; i<=7; i++) {
            if (startDate.equals(dates.get(i))) {
                dateIdx = i;
            }
        }
        return dateIdx;
    }

    private int calculateNumberOfDays() {
        return Month.findMonth(month).getLastDay();
    }

    private Map<Integer, Integer> castDatesToDays() {
        int startDateIdx = calculateStartDateIdx();
        int numberOfDays = calculateNumberOfDays();

        Map<Integer, Integer> DatesToDays = new HashMap<>();

        for (int day=1; day<=numberOfDays; day++) {
            DatesToDays.put(day, startDateIdx);
            startDateIdx++;
            if (startDateIdx>7) {
                startDateIdx = 1;
            }
        }

        return DatesToDays;
    }

}
