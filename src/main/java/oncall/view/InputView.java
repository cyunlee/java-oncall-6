package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import oncall.exception.InputValidator;
import oncall.util.InputParser;

public class InputView {
    private final InputParser inputParser = new InputParser();
    private final InputValidator inputValidator = new InputValidator();

    public Map<Integer, String> readMonthAndDate() {
        String input = Console.readLine();
        return inputParser.parseMonthAndDate(input);
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
