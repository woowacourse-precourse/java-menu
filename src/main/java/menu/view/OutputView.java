package menu.view;

import menu.constants.DayOfWeek;
import menu.model.Coach;
import menu.model.Coaches;
import menu.model.SelectCategory;

import java.util.List;

public class OutputView {
    private static final String START_MENU_RECOMMEND = "점심 메뉴 추천을 시작합니다.";
    private static final String MENU_RECOMMEND_RESULT = "\n메뉴 추천 결과입니다.";
    private static final String END_MENU_RECOMMEND = "\n추천을 완료했습니다.";
    private static final String START_RESULT = "[ ";
    private static final String END_RESULT = " ]";
    private static final String SEPARATOR = " | ";
    private static final String DAY_OF_WEEK_TITLE = "구분";

    public void printStartProgram() {
        System.out.println(START_MENU_RECOMMEND);
    }

    public void printEndProgram() {
        System.out.println(END_MENU_RECOMMEND);
    }

    public void printResultMenuRecommend(SelectCategory selectCategory, Coaches coaches) {
        System.out.println(MENU_RECOMMEND_RESULT);
        generateResult(selectCategory, coaches);
    }

    private void generateResult(SelectCategory selectCategory, Coaches coaches) {
        printDayOfWeek();
        printCategory(selectCategory);
        printCoachesRecommendMenu(coaches);
    }

    private void printDayOfWeek() {
        List<String> dayOfWeek = DayOfWeek.getWeekOfDayList();
        dayOfWeek.add(0, DAY_OF_WEEK_TITLE);
        System.out.println(setFormat(dayOfWeek));
    }

    private void printCategory(SelectCategory selectCategory) {
        System.out.println(setFormat(selectCategory.getSelectCategoryForPrint()));
    }

    private void printCoachesRecommendMenu(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            System.out.println(getRecommendMenu(coach));
        }
    }

    private String getRecommendMenu(Coach coach) {
        List<String> dayOfWeek = coach.getSelectMenu();
        dayOfWeek.add(0, DAY_OF_WEEK_TITLE);
        return setFormat(dayOfWeek);
    }

    private String setFormat(List<String> values) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(START_RESULT);
        stringBuilder.append(String.join(SEPARATOR, values));
        stringBuilder.append(END_RESULT);
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }
}
