package menu.view;

import menu.domain.menucategory.MenuCategory;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import static java.text.MessageFormat.format;

public class OutputView {
    private static final String RECOMMEND_LIST = "\n메뉴 추천 결과입니다.\n[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORIES = "[ 카테고리 | {0} | {1} | {2} | {3} | {4} ]";
    private static final String RECOMMEND_MENUS = "[ {0} | {1} | {2} | {3} | {4} | {5} ]";
    private static final String END_RECOMMEND = "\n추천을 완료했습니다.";
    private static final String START_RUN = "점심 메뉴 추천을 시작합니다.\n";
    private static final String ERROR = "[ERROR] ";

    public void printStartMessage() {
        System.out.println(START_RUN);
    }
    public void printError(String message) {
        System.out.println(ERROR + message);
    }

    public void printStartRecommend() {
        System.out.println(RECOMMEND_LIST);
    }

    public void printRecommendedMenus(String name, List<String> menus) {
        Queue<String> getMenu = new LinkedList<>(menus);
        System.out.println(format(RECOMMEND_MENUS, name,
                getMenu.poll(), getMenu.poll(),
                getMenu.poll(), getMenu.poll(),
                getMenu.poll()));
    }

    public void printCategories(List<MenuCategory> categories) {
        List<String> categoriesName = categories.stream().map(MenuCategory::name).collect(Collectors.toList());
        Queue<String> getCategories = new LinkedList<>(categoriesName);

        System.out.println(format(CATEGORIES, getCategories.poll(), getCategories.poll(),
                getCategories.poll(), getCategories.poll(), getCategories.poll()));
    }

    public void printEndMessage() {
        System.out.println(END_RECOMMEND);
    }
}
