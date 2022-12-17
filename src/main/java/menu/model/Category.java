package menu.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Category {
    JAPANESE("일식", "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼", 1),
    KOREAN("한식", "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음", 2),
    CHINESE("중식", "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채", 3),
    ASIAN("아시안", "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜", 4),
    WESTERN("양식", "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니", 5);
    
    private final String name;
    private final String menus;
    private final int order;

    Category(String name, String menus, int order) {
        this.name = name;
        this.menus = menus;
        this.order = order;
    }

    public String getMenus() {
        return menus;
    }

    public String getName() {
        return name;
    }

    public static List<String> getMenusByCategory(String categoryInput) {
        return Arrays.stream(getMenus(categoryInput).split(", ")).collect(Collectors.toList());
    }

    private static String getMenus(String categoryInput) {
        return Arrays
                .stream(values())
                .filter(category -> category.name.equals(categoryInput))
                .findFirst()
                .get()
                .getMenus();
    }

    public static Category getCategoryByRandomNumber(int random) {
        return Arrays
                .stream(values())
                .filter(category -> category.order == random)
                .findFirst()
                .get();
    }
}
