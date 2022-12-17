package menu.view;

import java.util.List;

public class OutputView {

    private void printCategoryName(List<String> categoryNames) {
        System.out.print("[ 카테고리");
        for (String name : categoryNames) {
            System.out.printf(" | %s", name);
        }
        System.out.println(" ]");
    }
}
