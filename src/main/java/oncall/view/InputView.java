package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import oncall.exception.InputValidator;
import oncall.util.InputParser;

public class InputView {
    private final InputParser inputParser = new InputParser();
    private final InputValidator inputValidator = new InputValidator();

    public Map<Integer, String> readCastInfo() {
        String input = Console.readLine();
        return inputParser.parseCastInfo(input);
    }

    public List<String> readWeekdays() {
        String input = Console.readLine();
        return inputParser.parsedWeekdaysWorkers(input);
    }

    public List<String> readWeekends() {
        String input = Console.readLine();
        return inputParser.parseWeekendsWorkers(input);
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