package menu.domain;

import static menu.domain.CategoryDecider.ASIAN;
import static menu.domain.CategoryDecider.CHINA;
import static menu.domain.CategoryDecider.JAPAN;
import static menu.domain.CategoryDecider.KOREAN;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MenuGiver {
    public final static List<String> JAPAN_MENU = Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘",
            "오코노미야끼");
    public final static List<String> KOREAN_MENU = Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이",
            "제육볶음");
    public final static List<String> CHINA_MENU = Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육",
            "토마토 달걀볶음", "고추잡채");
    public final static List<String> ASIAN_MENU = Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미",
            "월남쌈", "분짜");
    public final static List<String> EUROPE_MENU = Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티",
            "피자", "파니니");

    public static List<String> giveMenu(String category) {
        if (Objects.equals(category, JAPAN)) {
            return JAPAN_MENU;
        }
        if (Objects.equals(category, KOREAN)) {
            return KOREAN_MENU;
        }
        if (Objects.equals(category, CHINA)) {
            return CHINA_MENU;
        }
        if (Objects.equals(category, ASIAN)) {
            return ASIAN_MENU;
        }
        return EUROPE_MENU;
    }

}

