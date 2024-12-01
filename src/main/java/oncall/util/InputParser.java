package oncall.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputParser {
    public Map<Integer, String> parseCastInfo(String input) {
        List<String> parsedInput = Arrays.asList(input.split(","));
        Map<Integer, String> parsedCastInfo = new HashMap<>();
        parsedCastInfo.put(Integer.parseInt(parsedInput.get(0)), parsedInput.get(1));

        return parsedCastInfo;
    }

    public List<String> parsedWeekdaysWorkers(String input) {
        return Arrays.asList(input.split(","));
    }

    public List<String> parseWeekendsWorkers(String input) {
        return Arrays.asList(input.split(","));
    }
}
