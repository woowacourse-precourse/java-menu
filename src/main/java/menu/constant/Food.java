package menu.constant;

import static menu.constant.Category.ASIAN;
import static menu.constant.Category.CHINESE;
import static menu.constant.Category.JAPANESE;
import static menu.constant.Category.KOREAN;
import static menu.constant.Category.WESTERN;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Food {

    규동(JAPANESE), 우동(JAPANESE), 미소시루(JAPANESE), 스시(JAPANESE), 가츠동(JAPANESE), 오니기리(JAPANESE), 하이라이스(JAPANESE), 라멘(
            JAPANESE), 오코노미야끼(JAPANESE),
    김밥(KOREAN), 김치찌개(KOREAN), 쌈밥(KOREAN), 된장찌개(KOREAN), 비빔밥(KOREAN), 칼국수(KOREAN), 불고기(KOREAN), 떡볶이(KOREAN), 제육볶음(
            KOREAN),
    깐풍기(CHINESE), 볶음면(CHINESE), 동파육(CHINESE), 짜장면(CHINESE), 짬뽕(CHINESE), 마파두부(CHINESE), 탕수육(CHINESE), 토마토_달걀볶음(
            CHINESE), 고추잡채(CHINESE),
    팟타이(ASIAN), 카오_팟(ASIAN), 나시고렝(ASIAN), 파인애플_볶음밥(ASIAN), 쌀국수(ASIAN), 똠얌꿍(ASIAN), 반미(ASIAN), 월남쌈(ASIAN), 분짜(ASIAN),
    라자냐(WESTERN), 그라탱(WESTERN), 뇨끼(WESTERN), 끼슈(WESTERN), 프렌치_토스트(WESTERN), 바게트(WESTERN), 스파게티(WESTERN), 피자(
            WESTERN), 파니니(WESTERN);

    private final Category category;

    Food(Category category) {
        this.category = category;
    }

    public static List<String> foodNamesFromCategory(Category category) {
        return Arrays.stream(values())
                .filter(food -> food.category.equals(category))
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    public static Food from(String foodNameWithSpace) {
        return Arrays.stream(values())
                .filter(foodName -> foodName.isEqualConsideringSpaceTo(foodNameWithSpace))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("음식을 찾지 못했습니다"));
    }

    private boolean isEqualConsideringSpaceTo(String foodNameWithSpace) {
        String foodNameWithoutSpace = foodNameWithSpace.replaceAll(" ", "_");
        return name().equals(foodNameWithoutSpace);
    }

    public Category getCategory() {
        return category;
    }

    public String getNameWithBlank() {
        return name().replaceAll("_", " ");
    }
}
