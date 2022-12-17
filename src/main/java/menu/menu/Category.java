package menu.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Category {
    JAPANESE_FOOD("일식", 1,
            Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN_FOOD("한식", 2,
            Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE_FOOD("중식", 3,
            Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN_FOOD("아시안", 4,
            Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN_FOOD("양식", 5,
            Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")),
    EMPTY("카테고리 해당 없음", 0, Arrays.asList(""));

    private String categoryName;
    private Integer categoryNumber;
    private List<String> menus;

    Category(String categoryName, Integer categoryNumber, List<String> menus) {
        this.categoryName = categoryName;
        this.categoryNumber = categoryNumber;
        this.menus = menus;
    }

    private int getCategoryNumber() {
        return categoryNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public static String get(int randomNumber) {
        for (Category category: Category.values()) {
            if (randomNumber == category.getCategoryNumber()) {
                return category.getCategoryName();
            }
        }
        return EMPTY.getCategoryName();
    }

    public List<String> getMenus() {
        return menus;
    }

    public static List<String> getMenus(String categoryName) {
        for (Category category: Category.values()) {
            if (categoryName == category.getCategoryName()) {
                return category.getMenus();
            }
        }
        return EMPTY.getMenus();
    }

    public static List<String> getAllMenus() {
        List<String> allMenus = new ArrayList<>();
        for (Category category: Category.values()) {
            for (String menu: category.menus) {
                allMenus.add(menu);
            }
        }
        return allMenus;
    }
}
