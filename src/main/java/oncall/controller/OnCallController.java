package oncall.controller;

import java.util.List;
import java.util.Map;
import oncall.domain.WorkerGenerator;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OnCallController {
    private final WorkerGenerator workersGenerator = new WorkerGenerator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Map<Integer, String> castInfo = requireCastInfo();
        List<String> weekdaysWorkers = requireWeekdaysWorkers();
        List<String> weekendsWorkers = requireWeekendsWorkers();
    }


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
