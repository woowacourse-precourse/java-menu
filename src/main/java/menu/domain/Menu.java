package menu.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Menu {
    JAPANESE_MENU(Category.JAPANESE,
            Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN_MENU(Category.KOREAN,
            Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE_MENU(Category.CHINESE,
            Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN_MENU(Category.ASIAN,
            Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN_MENU(Category.WESTERN,
            Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private static final String DOES_NOT_EXIST_CATEGORY_ERROR = "존재하지 않는 카테고리입니다.";
    private static final String DOES_NOT_EXIST_MENU_ERROR = "존재하지 않는 메뉴를 입력했습니다.";

    private final Category category;
    private final List<String> menus;

    Menu(Category category, List<String> menus) {
        this.category = category;
        this.menus = menus;
    }

    public static Menu fromInput(Category input) {
        return Arrays.stream(values())
                .filter(menu -> menu.getCategory().equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(DOES_NOT_EXIST_CATEGORY_ERROR));
    }

    public static void validateExistedMenus(List<String> menus) {
        if (menus.isEmpty()) {
            return;
        }
        for (String menu : menus) {
            validateExistedMenu(menu);
        }
    }

    public static void validateExistedMenu(String inputMenu) {
        Arrays.stream(values())
                .filter(menu -> menu.menus.contains(inputMenu.trim()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(DOES_NOT_EXIST_MENU_ERROR));
    }

    public Category getCategory() {
        return category;
    }

    public List<String> getMenus() {
        return Collections.unmodifiableList(menus);
    }
}
