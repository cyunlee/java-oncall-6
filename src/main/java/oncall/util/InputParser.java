package oncall.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputParser {
    public Map<Integer, String> parseMonthAndDate(String input) {
        List<String> parsedInput = Arrays.asList(input.split(","));
        Map<Integer, String> parsedMonthAndDate = new HashMap<>();
        parsedMonthAndDate.put(Integer.parseInt(parsedInput.get(0)), parsedInput.get(1));
        return parsedMonthAndDate;
    }

    public List<String> parseWorkers(String input) {
        return Arrays.asList(input.split(","));
    }
}
