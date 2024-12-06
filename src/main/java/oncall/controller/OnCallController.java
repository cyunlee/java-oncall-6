package oncall.controller;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import oncall.domain.Holiday;
import oncall.domain.OnCall;
import oncall.domain.Worker;
import oncall.domain.WorkerGenerator;
import oncall.domain.Workers;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OnCallController {
    private int month;
    private String startDate;
    private final WorkerGenerator workerGenerator = new WorkerGenerator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Map<Integer, String> monthAndDate = requireMonthAndDate();
        for (Entry<Integer, String> entry : monthAndDate.entrySet()) {
            month = entry.getKey();
            startDate = entry.getValue();
        }
        Workers weekdayWorkers = generateWeekdayWorkers();
        Workers weekendWorkers = generateWeekendWorkers();
        OnCall onCall = new OnCall(month, startDate);
        Workers castedWorkers = castWorkers(onCall, weekdayWorkers, weekendWorkers);
        Map<Integer, String> convertedDates = convertDateIdxToReal(onCall.castDatesToDays());
        List<Integer> foundHolidays = findDayHolidayAndWeekday(onCall, month, onCall.castDatesToDays());
        showOnCall(month, convertedDates, castedWorkers, foundHolidays);
    }

    private Workers generateWeekdayWorkers() {
        return workerGenerator.generateWorker(requireWeekdayWorkers());
    }

    private Workers generateWeekendWorkers() {
        return workerGenerator.generateWorker(requireWeekendWorkers());
    }

    private Workers castWorkers(OnCall onCall, Workers weekdayWorkers, Workers weekendWorkers) {
        int numberOfDays = onCall.calculateNumberOfDays();
        int numberOfWorkers = weekdayWorkers.getSize();
        int weekdayIdx = 1;
        int weekendIdx = 1;
        Workers castedWorkers = new Workers();
        for (int day=1; day<=numberOfDays; day++) {
            if(onCall.isTodayWeekday(day) && !Holiday.isTodayHoliday(month, day)) {
                Worker worker = weekdayWorkers.getWorker(weekdayIdx);
                if (castedWorkers.getSize() >= 1 && castedWorkers.getLastWorker().equals(worker)) {
                    worker = weekdayWorkers.getWorker(weekdayIdx+1);
                }
                castedWorkers.addWorker(worker);
                weekdayIdx++;
                if (weekdayIdx == numberOfWorkers) {
                    weekdayIdx = 1;
                }
            }
            if (onCall.isTodayWeekday(day) && Holiday.isTodayHoliday(month, day)) {
                Worker worker = weekendWorkers.getWorker(weekendIdx);
                if (castedWorkers.getSize() >= 1 && castedWorkers.getLastWorker().equals(worker)) {
                    worker = weekendWorkers.getWorker(weekendIdx+1);
                }
                castedWorkers.addWorker(worker);
                weekendIdx++;
            }
            if(onCall.isTodayWeekend(day)) {
                Worker worker = weekendWorkers.getWorker(weekendIdx);
                if (castedWorkers.getSize() >=1 && castedWorkers.getLastWorker().equals(worker)) {
                    worker = weekendWorkers.getWorker(weekendIdx+1);
                }
                castedWorkers.addWorker(worker);
                weekendIdx++;
                if (weekendIdx == numberOfWorkers) {
                    weekendIdx = 1;
                }
            }
        }
        return castedWorkers;
    }

    private Map<Integer, String> convertDateIdxToReal(Map<Integer, Integer> castedDates) {
        Map<Integer, String> convertedDateIdxToReal = new HashMap<>();
        for (Entry<Integer, Integer> entry : castedDates.entrySet()) {
            if (entry.getValue()==1) {
                convertedDateIdxToReal.put(entry.getKey(), "월");
            }
            if (entry.getValue()==2) {
                convertedDateIdxToReal.put(entry.getKey(), "화");
            }
            if (entry.getValue()==3) {
                convertedDateIdxToReal.put(entry.getKey(), "수");
            }
            if (entry.getValue()==4) {
                convertedDateIdxToReal.put(entry.getKey(), "목");
            }
            if (entry.getValue()==5) {
                convertedDateIdxToReal.put(entry.getKey(), "금");
            }
            if (entry.getValue()==6) {
                convertedDateIdxToReal.put(entry.getKey(), "토");
            }
            if (entry.getValue()==7) {
                convertedDateIdxToReal.put(entry.getKey(), "일");
            }
        }
        return convertedDateIdxToReal;
    }

    private List<Integer> findDayHolidayAndWeekday(OnCall onCall, int month, Map<Integer, Integer> castedDates) {
        List<Integer> foundHolidays = new ArrayList<>();
        for (Entry<Integer, Integer> entry : castedDates.entrySet()) {
            if (onCall.isTodayWeekday(entry.getKey()) && Holiday.isTodayHoliday(month, entry.getKey())) {
                foundHolidays.add(entry.getKey());
            }
        }
        return foundHolidays;
    }

    private void showOnCall(int month, Map<Integer, String> calendar, Workers castedWorkers, List<Integer> foundHolidays) {
        outputView.printOnCallResult(month, calendar, castedWorkers, foundHolidays);
    }

    private Map<Integer, String> requireMonthAndDate() {
        outputView.printMonthAndDatePrompt();
        return inputView.readMonthAndDate();
    }

    private List<String> requireWeekdayWorkers() {
        outputView.printWeekdayWorkersPrompt();
        return inputView.readWeekdayWorkers();
    }

    private List<String> requireWeekendWorkers() {
        outputView.printWeekendWorkersPrompt();
        return inputView.readWeekendWorkers();
    }
}
