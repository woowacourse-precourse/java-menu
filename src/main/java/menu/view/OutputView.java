package menu.view;

import menu.model.Coach;

import java.util.List;

public class OutputView {

    private void printCategoryName(List<String> categoryNames) {
        System.out.print("[ 카테고리");
        for (String name : categoryNames) {
            System.out.printf(" | %s", name);
        }
        System.out.println(" ]");
    }

    private void printCoachMenus(List<Coach> coaches) {
        for (Coach coach : coaches) {
            System.out.printf("[ %s", coach.getName());

            for (String menu : coach.getMyMenu()) {
                System.out.printf(" | %s", menu);
            }
            System.out.println(" ]");
        }
    }
}
