package menu.domain.constants;

import java.util.Arrays;
import java.util.List;

import static menu.util.ErrorCode.NOT_VALID_CATEGORY;
import static menu.util.ErrorCode.NOT_VALID_MENU;

public enum Category {
    JAPANESE(1, "일식", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN(2, "한식", List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE(3, "중식", List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN(4, "아시안", List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN(5, "양식", List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    public static final String START_CATEGORY = "카테고리";
    private final int symbol;
    private final String name;
    private final List<String> menuList;

    Category(int symbol, String name, List<String> menuList) {
        this.symbol = symbol;
        this.name = name;
        this.menuList = menuList;
    }

    public static Category getCategoriesBySymbol(int input) {
        return Arrays.stream(Category.values())
                .filter(category -> category.symbol == input)
                .findFirst()
                .orElseThrow(NOT_VALID_CATEGORY::throwError);
    }

    public static List<String> getMenusByCategory(Category todayCategory) {
        return Arrays.stream(values())
                .filter(category -> category.equals(todayCategory))
                .findFirst()
                .orElseThrow(NOT_VALID_CATEGORY::throwError)
                .menuList;
    }

    public static void validateMenu(List<String> menuList) {
        if (menuList.size() == 0) {
            return;
        }
        for (String menu : menuList) {
            if (!Category.isMenuInCategory(menu)) {
                throw NOT_VALID_MENU.throwError();
            }
        }
    }

    public static boolean isMenuInCategory(String input) {
        return Arrays.stream(values())
                .map(category -> category.menuList)
                .anyMatch(menuList -> menuList.contains(input));
    }

    public String getName() {
        return name;
    }
}
