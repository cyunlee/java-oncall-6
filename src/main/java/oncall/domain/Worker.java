package oncall.domain;

public class Worker {
    private String nickname;
    private int weekdaysNumber;
    private int weekendsNumber;

    public Worker(String nickname, int weekdaysNumber) {
        this.nickname = nickname;
        this.weekdaysNumber = weekdaysNumber;
    }

    //수아, 랄라, 포비, 시윤
    //랄라, 수아, 시윤, 포비

    //평일과 휴일 무조건 한 번씩 배정되기 때문에 평일 먼저 추가하고 그다음에 weekendr순번 값을 modify하는 식으로
    public void modifyWorkerInfo(String nickname, int weekendNumber) {
        if (nickname.equals(this.nickname)) {
            this.weekendsNumber = weekendNumber;
        }
    }

    public int getWeekdaysNumber() {
        return weekdaysNumber;
    }

    public int getWeekendsNumber() {
        return weekendsNumber;
    }

}
