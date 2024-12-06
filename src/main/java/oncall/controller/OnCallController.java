package oncall.controller;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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


    }

    public Workers generateWeekdayWorkers() {
        return workerGenerator.generateWorker(requireWeekdayWorkers());
    }

    public Workers generateWeekendWorkers() {
        return workerGenerator.generateWorker(requireWeekendWorkers());
    }

    public Workers castWorkers(OnCall onCall, Workers weekdayWorkers, Workers weekendWorkers) {
        int numberOfDays = onCall.calculateNumberOfDays();
        int numberOfWorkers = weekdayWorkers.getSize();
        int weekdayIdx = 1;
        int weekendIdx = 1;
        Workers castedWorkers = new Workers();
        for (int day=1; day<=numberOfDays; day++) {
            if(onCall.isTodayWeekday(day)) {
                Worker worker = weekdayWorkers.getWorker(weekdayIdx);
                castedWorkers.addWorker(worker);
                weekdayIdx++;
                if (weekdayIdx == numberOfWorkers) {
                    weekdayIdx = 1;
                }
            }
            if(onCall.isTodayWeekend(day)) {
                Worker worker = weekendWorkers.getWorker(weekendIdx);
                castedWorkers.addWorker(worker);
                weekendIdx++;
                if (weekendIdx == numberOfWorkers) {
                    weekendIdx = 1;
                }
            }
        }
        return castedWorkers;
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
