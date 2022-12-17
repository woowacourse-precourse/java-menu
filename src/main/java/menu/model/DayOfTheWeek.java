package menu.model;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public enum DayOfTheWeek {
    MONDAY("월")
    , TUESDAY("화")
    , WEDNESDAY("수")
    , THURSDAY("목")
    , FRIDAY("금")
    ;

    private final String date;

    DayOfTheWeek(String date) {
        this.date = date;
    }

    public String getDayOfTheWeek() {
        return date;
    }
}
