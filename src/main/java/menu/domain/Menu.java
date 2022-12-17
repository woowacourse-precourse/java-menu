package menu.domain;

import java.util.Arrays;
import java.util.List;

public enum Menu {
    JAPANESE("일식", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"), 1),
    KOREAN("한식", List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"), 2),
    CHINESE("중식", List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"), 3),
    ASIAN("아시안", List.of("팟타이", "카오 팟", "나시고랭", "파인애플 볶음밥", "쌀국수", "똠양꿍", "반미", "월남쌈", "분짜"), 4),
    WESTERN("양식", List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"), 5);

    private static final String CODE_EXCEPTION_MESSAGE = "[ERROR] 해당되는 코드의 메뉴 카테고리가 없습니다.";

    public static final int MIN_CODE = 1;
    public static final int MAX_CODE = 5;

    private final String category;
    private final List<String> foods;
    private final int code;

    Menu(String category, List<String> foods, int code) {
        this.category = category;
        this.foods = foods;
        this.code = code;
    }

    public static Menu findByCode(int code) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.code == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(CODE_EXCEPTION_MESSAGE));
    }

    public List<String> getFoods() {
        return foods;
    }

    public String getCategory() {
        return category;
    }
}
