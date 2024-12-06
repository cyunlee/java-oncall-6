package oncall.exception;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
    private final static List<Integer> month = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    private final static String INPUT_INVALID_ERROR = "입력 값은 빈 값이 될 수 없습니다. 다시 입력해주세요.";
    private final static String INPUT_RANGE_INVALID_ERROR = "유효하지 않은 입력 값입니다. 다시 입력해 주세요.";

    public void validateInput(String input) {
        checkIsInputValid(input);
    }

    public void validateMonthValid(int input) {
        checkIsMonthValid(input);
    }

    private void checkIsInputValid(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_INVALID_ERROR);
        }
    }

    private void checkIsMonthValid(int input) {
        if (!month.contains(input)) {
            throw new IllegalArgumentException(INPUT_RANGE_INVALID_ERROR);
        }
    }
}
