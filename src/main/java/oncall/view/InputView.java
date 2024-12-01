package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import oncall.exception.InputValidator;
import oncall.util.InputParser;

public class InputView {
    private final InputParser inputParser = new InputParser();
    private final InputValidator inputValidator = new InputValidator();

    public String readStart() {
        String input = Console.readLine();
        List<String> parsedCastInfo = inputParser.parseCastInfo(input);
        return input;
    }

    public String readWeekdays() {
        String input = Console.readLine();
        List<String> parsedWeekdaysWorkers = inputParser.parsedWeekdaysWorkers(input);
        return input;
    }

    public String readWeekends() {
        String input = Console.readLine();
        List<String> parsedWeekendsWorkers = inputParser.parseWeekendsWorkers(input);
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