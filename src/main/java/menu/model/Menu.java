package menu.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private Map<Category, List<String>> menu = new HashMap<>();

    public Menu() {
        menu.put(Category.JAPANESE_FOOD, makeJapaneseFood());
        menu.put(Category.KOREAN_FOOD, makeKoreanFood());
        menu.put(Category.CHINESE_FOOD, makeChineseFood());
        menu.put(Category.ASIAN_FOOD, makeAsianFood());
        menu.put(Category.WESTON_FOOD, makeWesternFood());
    }

    private List<String> makeCategory() {
        return Arrays.asList("일식", "한식", "중식", "아시안", "양식");
    }

    private List<String> makeKoreanFood() {
        return Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
    }

    private List<String> makeJapaneseFood() {
        return Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼");
    }


    private List<String> makeChineseFood() {
        return Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채");
    }

    private List<String> makeAsianFood() {
        return Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");
    }

    private List<String> makeWesternFood() {
        return Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니");
    }
}
