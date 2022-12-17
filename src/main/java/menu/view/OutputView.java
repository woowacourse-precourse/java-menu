package menu.view;

import menu.domain.Coach;
import menu.domain.DayRecommend;
import menu.domain.FoodCategory;

import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

public class OutputView {
    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printServiceIntroducingMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printResultMessage(Map<DayRecommend, FoodCategory> result) {
        printDays();
        printCategories(result);
        printMemberRecommend(result);
    }

    private void printDays() {
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    private void printCategories(Map<DayRecommend, FoodCategory> result) {
        StringJoiner joiner = new StringJoiner(" | ", "[ ", " ]");
        joiner.add("카테고리");
        joiner.add(getCategoryOf(result, "월요일"));
        joiner.add(getCategoryOf(result, "화요일"));
        joiner.add(getCategoryOf(result, "수요일"));
        joiner.add(getCategoryOf(result, "목요일"));
        joiner.add(getCategoryOf(result, "금요일"));
        System.out.println(joiner.toString());
    }

    private String getCategoryOf(Map<DayRecommend, FoodCategory> result, String day) {
        DayRecommend target = getDayRecommendOfDayOf(result, day);
        return result.get(target).name();
    }

    private DayRecommend getDayRecommendOfDayOf(Map<DayRecommend, FoodCategory> result, String day) {
        return result.keySet().stream()
                .filter(dayRecommend -> dayRecommend.is(day))
                .findAny()
                .get();
    }

    private void printMemberRecommend(Map<DayRecommend, FoodCategory> result) {
        Set<Coach> coaches = result.keySet().stream().findAny().get().getRecommendData().keySet();
        for (Coach coach : coaches) {
            printCoachDiet(result, coach);
        }
    }

    private void printCoachDiet(Map<DayRecommend, FoodCategory> result, Coach coach) {
        StringJoiner joiner = new StringJoiner(" | ", "[ ", " ]");
        joiner.add(coach.getName());
        joiner.add(getMenuOf(result, coach, "월요일"));
        joiner.add(getMenuOf(result, coach, "화요일"));
        joiner.add(getMenuOf(result, coach, "수요일"));
        joiner.add(getMenuOf(result, coach, "목요일"));
        joiner.add(getMenuOf(result, coach, "금요일"));
        System.out.println(joiner.toString());
    }

    private String getMenuOf(Map<DayRecommend, FoodCategory> result, Coach coach, String day) {
        DayRecommend dayRecommendOfDayOf = getDayRecommendOfDayOf(result, day);
        return dayRecommendOfDayOf.getMenuOf(coach).getMenuName();
    }
}

