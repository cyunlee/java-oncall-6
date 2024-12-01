package oncall.controller;

import java.util.List;
import java.util.Map;
import oncall.domain.WorkerGenerator;
import oncall.domain.Workers;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OnCallController {
    private final WorkerGenerator workersGenerator = new WorkerGenerator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Map<Integer, String> castInfo = requireCastInfo();
        List<String> weekdaysWorkersName = requireWeekdaysWorkers();
        List<String> weekendsWorkersName = requireWeekendsWorkers();
        Workers workers = workersGenerator.generateWorkers(weekdaysWorkersName, weekendsWorkersName);
        Workers weekdaysWorkers = new Workers(workers.sortedByWeekdaysIdx());
        Workers weekendsWorkers = new Workers(workers.sortedByWeekendsIdx());
    }

    //만약 월요일부터 근무를 배치한다
    //월, 화, 수, 목, 금 -> 사이클 : 5
    //토요일, 일요일, 법정 공휴일


    private Map<Integer, String> requireCastInfo() {
        outputView.printCastInfoPrompt();
        return inputView.readCastInfo();
    }

    private List<String> requireWeekdaysWorkers() {
        outputView.printWeekdaysPrompt();
        return inputView.readWeekdays();
    }

    private List<String> requireWeekendsWorkers() {
        outputView.printWeekendsPrompt();
        return inputView.readWeekends();
    }
}
