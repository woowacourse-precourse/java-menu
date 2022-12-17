package menu.utill;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.KindAndFood;
import menu.domain.Result;

public class Convertor {
    public static List<String> toFoodList(List<KindAndFood> result) {
        return result.stream().
                map(ele -> ele.getFood().getFood())
                .collect(Collectors.toList());
    }

    public static String toStringCategories(List<String> categories) {
        categories.add(0, "카테고리");
        String result = String.join(" | ", categories);
        return "[ " + result + " ]";
    }

    public static List<String> toStringMenu(List<Result> results) {
        List<String> menuResult = new ArrayList<>();
        results.stream()
                .forEach(result -> inputMenu(result, menuResult));
        return menuResult;
    }

    private static void inputMenu(Result result, List<String> menuResult) {
        List<String> menus = result.getFoods();
        String name = result.getName();
        menus.add(0, name);
        String stringMenus = String.join(" | ", menus);
        menuResult.add("[ " + stringMenus + " ]");
    }


}
