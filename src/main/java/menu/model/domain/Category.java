package menu.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum Category {
    JAPANESE("일식", 1, new ArrayList<>(List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"))),
    KOREAN("한식", 2, new ArrayList<>(List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"))),
    CHINESE("중식", 3, new ArrayList<>(List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"))),
    ASIAN("아시안", 4, new ArrayList<>(List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"))),
    WESTERN("양식", 5, new ArrayList<>(List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")));

    private final String name;
    private final int randomValue;
    private final List<String> menus;

    Category(String name, int randomValue, List<String> menus) {
        this.name = name;
        this.randomValue = randomValue;
        this.menus = menus;
    }

    public String getName() {
        return name;
    }

    public static Category takeRandomCategory(int pickValue) {
        return Arrays.stream(values())
                .filter(category -> Objects.equals(category.randomValue, pickValue))
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("카테고리에 지정되지 않은 난수입니다.");
                });
    }

    public static boolean isExistMenu(String menuName) {
        return Arrays.stream(values())
                .map(category -> category.menus)
                .anyMatch(menus -> menus.contains(menuName));
    }

    public String getRandomMenu() {
        return Randoms.shuffle(menus).get(0);
    }
}
