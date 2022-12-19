package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum CategoryMenu {
    JAPAN_FOOD(List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스","라멘","오코노미야끼"), "일식",1),
    KOREA_FOOD(List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기","떡볶이","제육볶음"), "한식",2),
    CHINA_FOOD(List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육","토마토 달걀볶음","고추잡채"), "중식",3),
    ASIA_FOOD(List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미","월남쌈","분짜"), "아시안",4),
    WEST_FOOD(List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티","피자","파니니"), "양식",5);

    private final List<String> menus;
    private final String categoryName;
    private final int categoryNumber;

    CategoryMenu(List<String> menus, String categoryName, int categoryNumber) {
        this.menus = menus;
        this.categoryName = categoryName;
        this.categoryNumber = categoryNumber;
    }

    public static void validateMenuName(String menu) {
        Arrays.stream(CategoryMenu.values())
                .filter(category -> category.menus.contains(menu))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
    }

    public static CategoryMenu getCategory(int number) {
        return Arrays.stream(CategoryMenu.values())
                .filter(categoryMenu -> categoryMenu.categoryNumber == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리 번호 입니다."));
    }

    public static List<String> getMenus(CategoryMenu categoryMenu) {
        return new ArrayList<>(categoryMenu.menus);
    }

    public String getCategoryName() {
        return categoryName;
    }
}
