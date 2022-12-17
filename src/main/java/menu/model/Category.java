package menu.model;

public enum Category {

    JAP(1, "일식"),
    KOR(2, "한식"),
    CHI(3, "중식"),
    ASI(4, "아시안"),
    FRE(5, "양식");

    private final int value;
    private final String mean;

    Category(int value, String mean) {
        this.value = value;
        this.mean = mean;
    }

    public String getValueToString() {
        return String.valueOf(value);
    }

    public int getValue() {
        return value;
    }

    public String getMean() {
        return mean;
    }
}
