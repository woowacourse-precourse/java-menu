package menu.view;


import static menu.constant.DayOfWeek.getDayOfWeek;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;

public class OutputView {

    public static final String START_PROGRAM = "점심 메뉴 추천을 시작합니다.\n";
    public static final String INPUT_COACH_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    public static final String INPUT_HATE_MENUS = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    public static final String RECOMMEND_RESULT = "메뉴 추천 결과입니다.";
    public static final String COMPLETE_RECOMMEND = "\n추천을 완료했습니다.";
    public static final String DIVISION = "구분";
    public static final String CATEGORY = "카테고리";
    public static final String LEFT_BRACKET = "[ ";
    public static final String RIGHT_BRACKET = " ]";
    public static final String DELIMITER = " | ";

    public void printStartProgram() {
        System.out.println(START_PROGRAM);
    }

    public void printInputCoachNames() {
        System.out.println(INPUT_COACH_NAMES);
    }

    public void printInputHateMenu(Coach coach) {
        System.out.println(coach + INPUT_HATE_MENUS);
    }

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printRecommendResult(List<Category> categories, List<Coach> coaches) {
        System.out.println(RECOMMEND_RESULT);
        printDivisions();
        printCategories(categories);
        printCoaches(coaches);
        System.out.println(COMPLETE_RECOMMEND);
    }

    private void printDivisions() {
        List<String> divisions = new ArrayList<>();
        divisions.add(DIVISION);
        divisions.addAll(getDayOfWeek());
        System.out.println(joinWords(divisions));
    }

    private void printCategories(List<Category> recommendedCategories) {
        List<String> categories = new ArrayList<>();
        categories.add(CATEGORY);
        recommendedCategories.stream().map(Category::toString).forEach(categories::add);
        System.out.println(joinWords(categories));
    }

    private void printCoaches(List<Coach> coaches) {
        for (Coach coach : coaches) {
            printCoach(coach);
        }
    }

    private void printCoach(Coach coach) {
        List<String> coachMenus = new ArrayList<>();
        coachMenus.add(coach.toString());
        coach.getRecommendedMenus().stream().map(Menu::toString).forEach(coachMenus::add);
        System.out.println(joinWords(coachMenus));
    }


    public String joinWords(List<String> words) {
        String result = LEFT_BRACKET;
        result += String.join(DELIMITER, words);
        result += RIGHT_BRACKET;
        return result;
    }
}
