package menu.View;

import menu.Domain.Categories;
import menu.Domain.Coach;
import menu.Domain.CoachRepository;

public class OutputView {

    public static void printCategories() {
        InfoMessages.RESULT.println();
        InfoMessages.WEEKEND.println();
        InfoMessages.CATEGORIES_START.print();
        System.out.print(String.join(InfoMessages.SEPERATOR.getMessage(),Categories.getCategories()));
        InfoMessages.CATEGORIES_END.println();
    }
    public static void printRecommendedMenus() {
        for (Coach coach : CoachRepository.getCoachList()) {
            InfoMessages.MENU_START.print();
            System.out.print(coach.getName());
            InfoMessages.SEPERATOR.print();
            System.out.print(String.join(InfoMessages.SEPERATOR.getMessage(), coach.getMenus()));
            InfoMessages.CATEGORIES_END.println();
        }
        InfoMessages.FINISH.println();
    }

}
