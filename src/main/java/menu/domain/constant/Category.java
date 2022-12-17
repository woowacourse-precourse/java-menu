package menu.domain.constant;

import static menu.domain.constant.MenuRule.COUNT_OF_CATEGORIES;
import static menu.domain.constant.MenuRule.START_NUMBER_OF_CATEGORY;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public enum Category {
    JAPANESE(1, "일식", Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN(2, "한식", Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE(3, "중식", Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN(4, "아시안", Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN(5, "양식", Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final int number;
    private final String name;
    private final List<String> menus;

    Category(int number, String name, List<String> menus) {
        this.number = number;
        this.name = name;
        this.menus = menus;
    }

    public static void checkFoodExist(String food) {
        boolean haveFood = false;
        for (Category category : Category.values()) {
            if (category.haveFood(food)) {
                haveFood = true;
                break;
            }
        }
        if (!haveFood) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴입니다.");
        }
    }

    private boolean haveFood(String food) {
        return menus.contains(food);
    }

    public static Category getRandomCategory() {
        int randomNumber = Randoms.pickNumberInRange(START_NUMBER_OF_CATEGORY, COUNT_OF_CATEGORIES);
        return Arrays.stream(Category.values())
                .filter(category -> category.isNumberOf(randomNumber))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 번호의 카테고리입니다."));
    }

    private boolean isNumberOf(int number) {
        return this.number == number;
    }

    public String getName() {
        return name;
    }
}
