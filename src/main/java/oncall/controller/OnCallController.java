package oncall.controller;

import oncall.view.InputView;
import oncall.view.OutputView;

public class OnCallController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String input = requireInput();
        start();
    }

    private void start() {
    }



    private String requireInput() {
        outputView.printPrompt();
        return inputView.readInput();
    }
}
