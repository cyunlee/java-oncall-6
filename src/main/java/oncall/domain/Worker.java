package oncall.domain;

public class Worker {
    private String nickname;
    private int weekdaysNumber;
    private int weekendsNumber;
    private boolean workOnWeekdays;
    private boolean workOnWeekends;

    public Worker(String nickname, int weekdaysNumber, int weekendsNumber) {
        this.nickname = nickname;
        this.weekdaysNumber = weekdaysNumber;
        this.weekendsNumber = weekendsNumber;

        if (weekdaysNumber!=0) {
            this.workOnWeekdays = true;
        }
        if (weekendsNumber!=0) {
            this.workOnWeekends = true;
        }
    }

    //만약 workOnWeekdays, workOnWeekends가 이미 true라면 더이상 생성할 수 없도록.
}
