package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum CategoryRegister {
    JAPANESE_FOOD("일식", "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼"),
    KOREAN_FOOD("한식", "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음"),
    CHINESE_FOOD("중식", "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채"),
    ASIAN_FOOD("아시안", "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜"),
    WESTERN_FOOD("양식", "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니");

    private String category;
    private static String menus;
    static Map<String, List<String>> categoryRegister = new HashMap<>();

    CategoryRegister(String category, String menu) {
    }

    public static void MenuListSave() {
        categoryRegister.put(CategoryRegister.JAPANESE_FOOD.category, Arrays.asList(CategoryRegister.JAPANESE_FOOD.menus.split(",")));
        categoryRegister.put(CategoryRegister.KOREAN_FOOD.category, Arrays.asList(CategoryRegister.KOREAN_FOOD.menus.split(",")));
        categoryRegister.put(CategoryRegister.CHINESE_FOOD.category, Arrays.asList(CategoryRegister.CHINESE_FOOD.menus.split(",")));
        categoryRegister.put(CategoryRegister.ASIAN_FOOD.category, Arrays.asList(CategoryRegister.ASIAN_FOOD.menus.split(",")));
        categoryRegister.put(CategoryRegister.WESTERN_FOOD.category, Arrays.asList(CategoryRegister.WESTERN_FOOD.menus.split(",")));
    }

    public static List<String> getMenus(String category){
        return categoryRegister.get(category);
    }
}
