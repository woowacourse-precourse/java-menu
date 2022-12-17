package menu.repository;

import menu.domain.Category;
import menu.domain.menucategory.MenuCategory;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRepository {
    private final static List<MenuCategory> categories = List.of(new MenuCategory("일식"), new MenuCategory("한식"), new MenuCategory("중식"), new MenuCategory("아시안"), new MenuCategory("양식"));
    private final static HashMap<MenuCategory, List<String>> menus = new HashMap<>();

    static {
        menus.put(categories.get(Category.JAPAN.value()), List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        menus.put(categories.get(Category.KOREAN.value()), List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        menus.put(categories.get(Category.CHINA.value()), List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        menus.put(categories.get(Category.ASIAN.value()), List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        menus.put(categories.get(Category.WESTERN.value()), List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    }

    private static boolean containsMenu(String menu, MenuCategory menuCategory) {
        for (String existMenu : menus.get(menuCategory)) {
            if (existMenu.equals(menu)) {
                return true;
            }
        }
        return false;
    }

    public static boolean menuExist(String menu) {
        for (MenuCategory menuCategory : menus.keySet()) {
            if (containsMenu(menu, menuCategory)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> getCategories() {
        return categories.stream()
                .map(MenuCategory::name)
                .collect(Collectors.toList());
    }

    public static MenuCategory getCategoryByName(String name) {
        for (MenuCategory menuCategory : categories) {
            if (name.equals(menuCategory.name())) {
                return menuCategory;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 카테고리입니다.");
    }
}
