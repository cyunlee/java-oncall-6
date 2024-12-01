package oncall.exception;

public class InputValidator {
    private final static String ERROR_MESSAGE = "입력값은 n자 이상을 넘을 수 없습니다.";

    public void validateInputLength(String input) {
        checkIsInputValid(input);
    }

    private void checkIsInputValid(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}