package oncall.domain;

public enum Date {
    JAN(31),
    FEB(28),
    MAR(31),
    APR(30),
    MAY(31),
    JUN(30),
    JUL(31),
    AUG(31),
    SEB(30),
    OCT(31),
    NOV(30),
    DEC(31);

    private int date;

    Date(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }
}
