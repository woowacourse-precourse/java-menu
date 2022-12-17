package menu.model;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public enum DayOfTheWeek {
    MONDAY("일식")
    , TUESDAY("한식")
    , WEDNESDAY("중식")
    , THURSDAY("아시안")
    , FRIDAY("양식")
    ;

    private final String date;

    DayOfTheWeek(String date) {
        this.date = date;
    }

    public String getDayOfTheWeek() {
        return date;
    }
}
