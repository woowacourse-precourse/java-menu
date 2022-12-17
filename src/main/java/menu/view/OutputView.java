package menu.view;

import java.util.Arrays;
import java.util.List;
import menu.domain.Categories;
import menu.domain.CoachRecommendMenu;
import menu.domain.enums.Category;
import menu.domain.enums.Day;
import menu.domain.enums.Menu;

public class OutputView {
    private static String createDayMessage() {
        StringBuilder dayMessage = new StringBuilder();
        Arrays.stream(Day.values()).map(Day::toString).forEach(day -> dayMessage.append(" ").append(day).append(" |"));
        return dayMessage.deleteCharAt(dayMessage.lastIndexOf("|")).toString();
    }

    private String createCategoryMessage(final Categories categories) {
        StringBuilder categoryMessage = new StringBuilder();
        categories.getCategories()
                .stream()
                .map(Category::getName)
                .forEach(name -> categoryMessage.append(" ").append(name).append(" |"));
        return categoryMessage.deleteCharAt(categoryMessage.lastIndexOf("|")).toString();
    }

    public void printMessage(final String message) {
        System.out.println(message);
    }

    public void printMenuRecommend(final List<CoachRecommendMenu> startMenuRecommend, final Categories categories) {
        System.out.println("메뉴 추천 결과입니다.");
        printInformation(categories);
        printCoachRecommendMenu(startMenuRecommend);
        System.out.println("추천을 완료했습니다.");

    }

    private void printCoachRecommendMenu(final List<CoachRecommendMenu> startMenuRecommend) {
        for (CoachRecommendMenu coachRecommendMenu : startMenuRecommend) {
            System.out.printf("[ %s |", coachRecommendMenu.getCoachName());
            System.out.print(createMenuMessage(coachRecommendMenu.getMenuList()));
            System.out.println("]");
        }
    }

    private String createMenuMessage(final List<Menu> menus) {
        StringBuilder menuMessage = new StringBuilder();
        menus.stream().map(Menu::getName).forEach(name -> menuMessage.append(" ").append(name).append(" |"));
        return menuMessage.deleteCharAt(menuMessage.lastIndexOf("|")).toString();
    }

    private void printInformation(final Categories categories) {
        System.out.print("[ 구분 |");
        System.out.print(createDayMessage());
        System.out.println("]");
        System.out.print("[ 카테고리 |");
        System.out.print(createCategoryMessage(categories));
        System.out.println("]");

    }

}
