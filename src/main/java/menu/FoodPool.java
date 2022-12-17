package menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodPool {
    public static final String[] japan = {"규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"};
    public static final String[] korea = {"김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"};
    public static final String[] china = {"깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"};
    public static final String[] asia = {"팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"};
    public static final String[] west = {"라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"};
    public static final String[][] categoryWithFood = {japan, korea, china, asia, west};
    public static final String[] category = {"일식", "한식", "중식", "아시안", "양식"};
    public static final Map<String, String[]> foods;

    static {
        foods = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            foods.put(category[i], categoryWithFood[i]);
        }
    }
}
