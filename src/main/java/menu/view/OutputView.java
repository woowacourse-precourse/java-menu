package menu.view;

import menu.global.Constants;
import menu.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printResult(final Category category,
                                   final Map<String, List<String>> menu) {
        printDay();
        printCategory(category);
        printMenu(menu);
    }

    private static void printDay() {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println(printMenu(Constants.DAY));
    }

    private static void printCategory(Category category) {
        System.out.println(printMenu(category.getCategories()));
    }

    private static String printMenu(final List<String> element) {
        StringBuilder stringBuilder = new StringBuilder("[ ");

        stringBuilder.append(String.join(" | ", element));

        stringBuilder.append(" ]");

        return stringBuilder.toString();
    }

    private static void printMenu(final Map<String, List<String>> element) {
        List<String> printing = new ArrayList<>();

        for (String key : element.keySet()) {
            printing.add(key);
            printing.addAll(element.get(key));

            System.out.println(printMenu(printing));
            printing.clear();
        }

        System.out.println("추천을 완료했습니다.");
    }
}
