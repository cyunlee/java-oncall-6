package oncall.view;

public class OutputView {
    private final static String ERROR = "[ERROR] ";

    public void printPrompt() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public static void printError(String message) {
        System.out.println(ERROR + message);
    }
}