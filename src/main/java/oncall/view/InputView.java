package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import oncall.exception.InputValidator;
import oncall.util.InputParser;

public class InputView {
    private final InputParser inputParser = new InputParser();
    private final InputValidator inputValidator = new InputValidator();

    public Map<Integer, String> readMonthAndDate() {
        try {
            String input = Console.readLine();
            Map<Integer, String> parsedInput = inputParser.parseMonthAndDate(input);
            for (Entry<Integer, String> entry : parsedInput.entrySet()) {
                inputValidator.validateMonthValid(entry.getKey());
            }
            return parsedInput;
        } catch(IllegalArgumentException exception) {
            OutputView.printError(exception.getMessage());
            return readMonthAndDate();
        }
    }

    public List<String> readWeekdayWorkers() {
        String input = Console.readLine();
        return inputParser.parseWorkers(input);
    }

    public List<String> readWeekendWorkers() {
        String input = Console.readLine();
        return inputParser.parseWorkers(input);
    }

}
