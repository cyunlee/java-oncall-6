package oncall.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import oncall.domain.Workers;

public class OutputView {
    private final static String ERROR = "[ERROR] ";

    public void printMonthAndDatePrompt() {
        System.out.println("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
    }

    public void printWeekdayWorkersPrompt() {
        System.out.println("평일 비상 근무 순번대로 사원 닉네임을 입력하세요>");
    }

    public void printWeekendWorkersPrompt() {
        System.out.println("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>");
    }

    public void printOnCallResult(int month, Map<Integer, String> calendar, Workers castedWorkers, List<Integer> foundHolidays) {
        int workerIdx = 1;
        String value = "";
        for (Entry<Integer, String> entry : calendar.entrySet()) {
            value = entry.getValue();
            if (foundHolidays.contains(entry.getKey())) {
                value += "(휴일)";
            }
            System.out.println(String.format("%d월 %d일 %s %s", month, entry.getKey(), value, castedWorkers.getWorker(workerIdx).getName()));
            workerIdx++;
        }
    }

    public static void printError(String message) {
        System.out.println(ERROR + message);
    }
}
