package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.exception.InputValidator;
import oncall.util.InputParser;

public class InputView {
    private final InputParser inputParser = new InputParser();
    private final InputValidator inputValidator = new InputValidator();

    public String readStart() {
        String input = Console.readLine();
        return input;
    }

    public String readWeekdays() {
        String input = Console.readLine();
        return input;
    }

    public String readWeekends() {
        String input = Console.readLine();
        return input;
    }

//    public String readInput() {
//        try{
//            String input = Console.readLine();
//            inputValidator.validateSth(input);
//            return input;
//        }catch(IllegalArgumentException exception) {
//            OutputView.printError(exception.getMessage());
//            return readInput();
//        }
//    }
}