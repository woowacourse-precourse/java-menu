package menu.repository;

import menu.domain.Menu;
import menu.enums.Category;

import java.lang.reflect.Array;
import java.util.*;

public class MenuRepository {
    private static List<Menu> menus = new ArrayList<>();
    private static Map<Category, List<String>> categoryMenus = new HashMap<>();

    private static String[] japan = new String[] {"규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼" };
    private static String[] korea = new String[] { "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"};
    private static String[] china = new String[] {"깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"};
    private static String[] asia = new String[] {"팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"};
    private static String[] western = new String[] {"라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자, 파니니"};

    static {
        categoryMenus.put(Category.getCategoryFromNumber(1), Arrays.asList(japan));
        categoryMenus.put(Category.getCategoryFromNumber(2), Arrays.asList(korea));
        categoryMenus.put(Category.getCategoryFromNumber(3), Arrays.asList(china));
        categoryMenus.put(Category.getCategoryFromNumber(4), Arrays.asList(asia));
        categoryMenus.put(Category.getCategoryFromNumber(5), Arrays.asList(western));


        List<String[]> tmp = Arrays.asList(japan, korea, china, asia, western);
        int categoryIdx = 1;

        for (String[] menuList : tmp) {
            for (String menuName : menuList) {
                menus.add(new Menu(Category.getCategoryFromNumber(categoryIdx), menuName));
            }
            ++categoryIdx;
        }
    }


    public static Menu getMenuByName(String menuName) {
        return menus.stream().filter(menu -> menu.isSameMenu(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR 선택할 수 없는 메뉴입니다."));
    }

    public static List<String> getMenusByCategory(Category category) {
        return categoryMenus.get(category);
        //없는 카테고리일 경우 validation
    }



}
