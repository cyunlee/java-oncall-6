package oncall.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public List<String> parseCastInfo(String input) {
        return Arrays.asList(input.split(","));
    }

    public List<String> parsedWeekdaysWorkers(String input) {
        return Arrays.asList(input.split(","));
    }

    public List<String> parseWeekendsWorkers(String input) {
        return Arrays.asList(input.split(","));
    }
}
