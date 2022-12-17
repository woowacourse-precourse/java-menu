package menu.view;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Week;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    static final String RECOMMEND_START = "점심 메뉴 추천을 시작합니다.\n";
    static final String PRINT_MENU = "메뉴 추천 결과입니다.\n";
    static final String FINISH = "추천을 완료했습니다.\n";
    static final String DELIMITER = " | ";
    static final String PREFIX = "[ ";
    static final String SUFFIX = " ]";

    public static void recommendStart(){
        System.out.println(RECOMMEND_START);
    }

    public static void printResult(List<Coach> coaches, List<Category> categories){
        System.out.println(PRINT_MENU);
        printWeek();
        printCategory(categories);
        printCoachRecommendMenu(coaches);
    }

    private static void printCoachRecommendMenu(List<Coach> coaches) {
        for(Coach coach : coaches){
            List<String> eatenMenu = coach.getEatenMenu();
            eatenMenu.add(0, coach.getName());
            String menu = eatenMenu.stream().collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
            System.out.println(menu);
        }
    }

    private static void printCategory(List<Category> categories) {
        categories.add(0,Category.CATEGORY);
        String category = categories
                .stream().map(Category::getName)
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
        System.out.println(category);
    }

    private static void printWeek() {
        String week = Arrays.stream(Week.values())
                .map(Week::getDay)
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
        System.out.println(week);
    }

    public static void quit(){
        System.out.println(FINISH);
    }
}
