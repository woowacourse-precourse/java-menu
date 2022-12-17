package menu.model;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public enum DayOfTheWeek {
    MONDAY("월요일")
    , TUESDAY("화요일")
    , WEDNESDAY("수요일")
    , THURSDAY("목요일")
    , FRIDAY("금요일")
    ;

    private final String date;

    DayOfTheWeek(String date) {
        this.date = date;
    }

    public String getDayOfTheWeek() {
        return date;
    }
}
