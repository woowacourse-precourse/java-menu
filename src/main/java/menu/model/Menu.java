package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private static final Integer MIN_DISLIKE_FOOD_SIZE = 0;
    private static final Integer MAX_DISLIKE_FOOD_SIZE = 2;

    private final Map<Category, List<String>> menu = new HashMap<>();
    private static Map<String, List<String>> dislikeFoods = new HashMap<>();

    public Menu() {
        menu.put(Category.JAPANESE_FOOD, makeJapaneseFood());
        menu.put(Category.KOREAN_FOOD, makeKoreanFood());
        menu.put(Category.CHINESE_FOOD, makeChineseFood());
        menu.put(Category.ASIAN_FOOD, makeAsianFood());
        menu.put(Category.WESTON_FOOD, makeWesternFood());
    }
    public void dislike(String coach, List<String> dislikeFood) {
        validate(dislikeFood);
        dislikeFoods.put(coach, dislikeFood);
    }

    public boolean isDislike(String coach, String food) {
        return dislikeFoods.get(coach).contains(food);
    }

    public String recommendFood(String category) {
        return Randoms.shuffle(menu.get(Category.getCategory(category))).get(0);
    }

    private void validate(List<String> dislikeFood) {
        if (!isValidSize(dislikeFood)) {
            throw new IllegalArgumentException("못먹는 음식의 크기는 최소 0개에서 최대 2개입니다.");
        }
        //Todo: 없는 음식에 대한 예외 상황처리
    }

    private boolean isValidSize(List<String> dislikeFood) {
        return MIN_DISLIKE_FOOD_SIZE <= dislikeFood.size() && dislikeFood.size() <= MAX_DISLIKE_FOOD_SIZE;
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
