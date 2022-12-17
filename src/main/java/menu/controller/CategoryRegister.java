package menu.controller;

import java.time.chrono.JapaneseEra;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryRegister {
    private static final String JAPANESE_FOOD = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼";
    private static final String KOREAN_FOOD= "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음";
    private static final String CHINESE_FOOD= "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채";
    private static final String ASIAN_FOOD="팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜";
    private static final String WESTERN_FOOD="라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니";

    private String category;
    private static String menus;
    static Map<String, List<String>> categoryRegister = new HashMap<>();

    CategoryRegister(String category, String menu) {
    }

    public static void MenuListSave() {

        categoryRegister.put("일식", Arrays.asList(CategoryRegister.JAPANESE_FOOD.split(",")));
        categoryRegister.put("한식", Arrays.asList(CategoryRegister.KOREAN_FOOD.split(",")));
        categoryRegister.put("중식", Arrays.asList(CategoryRegister.CHINESE_FOOD.split(",")));
        categoryRegister.put("아시안", Arrays.asList(CategoryRegister.ASIAN_FOOD.split(",")));
        categoryRegister.put("서양", Arrays.asList(CategoryRegister.WESTERN_FOOD.split(",")));
    }

    public static List<String> getMenus(String category){
        return categoryRegister.get(category);
    }
}
