package oncall.view;

public class OutputView {
    private final static String ERROR = "[ERROR] ";

    public void printStartPrompt() {
        System.out.println("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
    }

    public void printWeekdaysPrompt() {
        System.out.println("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public void printWeekendsPrompt() {
        System.out.println("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public static void printError(String message) {
        System.out.println(ERROR + message);
    }
}