package oncall.controller;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
    }



    public Workers generateWeekdayWorkers() {
        return workerGenerator.generateWorker(requireWeekdayWorkers());
    }

    public Workers generateWeekendWorkers() {
        return workerGenerator.generateWorker(requireWeekendWorkers());
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
