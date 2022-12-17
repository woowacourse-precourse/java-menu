package menu.view;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;

public class OutputView {
    private final static String SERVICE_START = "점심 메뉴 추천을 시작합니다.\n";
    private final static String RECOMMEND_RESULT_DAY_WEEK = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private final static String RECOMMEND_RESULT_CATEGORY = "[ 카테고리 | ";
    private final static String RECOMMEND_RESULT_PARTITION = " | ";
    private final static String RECOMMEND_RESULT_START = "[ ";
    private final static String RECOMMEND_RESULT_END = " ]";
    private final static String SERVICE_END = "추천을 완료했습니다.";

    public void printServiceStart() {
        System.out.println(SERVICE_START);
    }

    public void printRecommendResult(List<Coach> coaches, List<Category> categories) {
        System.out.println(RECOMMEND_RESULT_DAY_WEEK);
        printCategories(categories);
        printCoachesMenu(coaches);
        System.out.println();
        System.out.println(SERVICE_END);
    }

    public void printCategories(List<Category> categories) {
        System.out.printf(RECOMMEND_RESULT_CATEGORY);
        for(int i = 0; i<categories.size(); i++) {
            Category category = categories.get(i);
            if(i != categories.size() - 1) {
                System.out.printf(category.getCategoryName() + RECOMMEND_RESULT_PARTITION);
                continue;
            }
            System.out.printf(category.getCategoryName());
        }
        System.out.println(RECOMMEND_RESULT_END);
    }

    public void printCoachesMenu(List<Coach> coaches) {
        for (Coach coach : coaches) {
            printCoachMenu(coach);
        }
    }

    public void printCoachMenu(Coach coach) {
        System.out.printf(RECOMMEND_RESULT_START);
        System.out.printf(coach.getCoachName() + RECOMMEND_RESULT_PARTITION);
        List<Menu> menus = coach.getRecommendMenus();
        for (int i = 0; i < menus.size(); i++) {
            Menu menu = menus.get(i);
            if(i != menus.size() - 1) {
                System.out.printf(menu.getMenuName() + RECOMMEND_RESULT_PARTITION);
                continue;
            }
            System.out.printf(menu.getMenuName());
        }
        System.out.println(RECOMMEND_RESULT_END);
    }
}
