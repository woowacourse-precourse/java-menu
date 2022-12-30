package menu.view;

import menu.domain.Coach;
import menu.domain.DayRecommend;
import menu.domain.MenuBoard;

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

    public void printResultMessage(Map<DayRecommend, MenuBoard> result) {
        printResultIntroducingMessage();
        printDays();
        printCategories(result);
        printMemberRecommend(result);
        printCompleteMessage();
    }

    public void printResultIntroducingMessage() {
        System.out.println("메뉴 추천 결과입니다.");
    }

    private void printDays() {
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    private void printCategories(Map<DayRecommend, MenuBoard> result) {
        StringJoiner joiner = new StringJoiner(" | ", "[ ", " ]");
        joiner.add("카테고리");
        joiner.add(getCategoryOf(result, "월요일"));
        joiner.add(getCategoryOf(result, "화요일"));
        joiner.add(getCategoryOf(result, "수요일"));
        joiner.add(getCategoryOf(result, "목요일"));
        joiner.add(getCategoryOf(result, "금요일"));
        System.out.println(joiner.toString());
    }

    private String getCategoryOf(Map<DayRecommend, MenuBoard> result, String day) {
        DayRecommend target = getDayRecommendOfDayOf(result, day);
        return result.get(target).name();
    }

    private DayRecommend getDayRecommendOfDayOf(Map<DayRecommend, MenuBoard> result, String day) {
        return result.keySet().stream()
                .filter(dayRecommend -> dayRecommend.is(day))
                .findAny()
                .get();
    }

    private void printMemberRecommend(Map<DayRecommend, MenuBoard> result) {
        Set<Coach> coaches = result.keySet().stream().findAny().get().getRecommendData().keySet();
        for (Coach coach : coaches) {
            printCoachDiet(result, coach);
        }
    }

    private void printCoachDiet(Map<DayRecommend, MenuBoard> result, Coach coach) {
        StringJoiner joiner = new StringJoiner(" | ", "[ ", " ]");
        joiner.add(coach.getName());
        joiner.add(getMenuOf(result, coach, "월요일"));
        joiner.add(getMenuOf(result, coach, "화요일"));
        joiner.add(getMenuOf(result, coach, "수요일"));
        joiner.add(getMenuOf(result, coach, "목요일"));
        joiner.add(getMenuOf(result, coach, "금요일"));
        System.out.println(joiner.toString());
    }

    private String getMenuOf(Map<DayRecommend, MenuBoard> result, Coach coach, String day) {
        DayRecommend dayRecommendOfDayOf = getDayRecommendOfDayOf(result, day);
        return dayRecommendOfDayOf.getMenuOf(coach).getMenuName();
    }

    private void printCompleteMessage() {
        System.out.println("추천을 완료했습니다.");
    }
}

