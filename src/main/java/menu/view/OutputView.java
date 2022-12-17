package menu.view;

import menu.domain.Day;
import menu.domain.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String PROGRAM_START_INFO_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String MENU_RECOMMEND_RESULT_INFO_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String MENU_RECOMMEND_RESULT_INFO_END_MESSAGE = "\n추천을 완료했습니다.";

    private static final String DAYS_TITLE = "구분";
    private static final String CATEGORY_TITLE = "카테고리";

    private static final String TABLE_START_SIGN = "[ ";
    private static final String TABLE_DIVIDE_SIGN = " | ";
    private static final String TABLE_END_SIGN = " ]";

    public void printProgramStartInfo() {
        System.out.println(PROGRAM_START_INFO_MESSAGE);
    }

    public void printResultInfoMessage() {
        System.out.println(MENU_RECOMMEND_RESULT_INFO_MESSAGE);
    }

    public void printResultInfoEndMessage() {
        System.out.println(MENU_RECOMMEND_RESULT_INFO_END_MESSAGE);
    }

    public void printDaysTable(List<Day> days) {
        List<String> dayNames = days.stream()
                .map(day -> day.toString())
                .collect(Collectors.toList());
        printTable(DAYS_TITLE, dayNames);
    }

    public void printCategoryTable(List<Menu> categories) {
        List<String> categoryNames = categories.stream()
                .map(menu -> menu.getCategory())
                .collect(Collectors.toList());
        printTable(CATEGORY_TITLE, categoryNames);
    }

    public void printFoodTable(String coachName, List<String> foods) {
        printTable(coachName, foods);
    }

    private void printTable(String title, List<String> components) {
        List<String> tableComponents = new ArrayList<>();
        tableComponents.add(title);
        tableComponents.addAll(components);
        System.out.println(tableRowBuilder(tableComponents));
    }


    private String tableRowBuilder(List<String> tableComponents) {
        StringBuilder rowBuilder = new StringBuilder(TABLE_START_SIGN);
        rowBuilder.append(String.join(TABLE_DIVIDE_SIGN, tableComponents));
        rowBuilder.append(TABLE_END_SIGN);

        return rowBuilder.toString();
    }
}
