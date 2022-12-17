package menu.domain.constant;

public enum Day {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private String dayInKorean;

    Day(String dayInKorean) {
        this.dayInKorean = dayInKorean;
    }

    public String getDayInKorean() {
        return dayInKorean;
    }
}
