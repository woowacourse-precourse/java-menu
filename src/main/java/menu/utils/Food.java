package menu.utils;

import menu.domain.Coach;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Food {
    // KOREA
    김밥("김밥", Category.KOREA),
    김치찌개("김치찌개", Category.KOREA),
    쌈밥("쌈밥", Category.KOREA),
    된장찌개("된장찌개", Category.KOREA),
    비빔밥("비빔밥", Category.KOREA),
    칼국수("칼국수", Category.KOREA),
    불고기("불고기", Category.KOREA),
    떡볶이("떡볶이", Category.KOREA),
    제육볶음("제육볶음", Category.KOREA),

    // JAPAN
    규동("규동", Category.JAPAN),
    우동("우동", Category.JAPAN),
    미소시루("미소시루", Category.JAPAN),
    스시("스시", Category.JAPAN),
    가츠동("가츠동", Category.JAPAN),
    오니기리("오니기리", Category.JAPAN),
    하이라이스("하이라이스", Category.JAPAN),
    라멘("라멘", Category.JAPAN),
    오코노미야끼("오코노미야끼", Category.JAPAN),

    // CHINA
    깐풍기("깐풍기", Category.CHINA),
    볶음면("볶음면", Category.CHINA),
    동파육("동파육", Category.CHINA),
    짜장면("짜장면", Category.CHINA),
    짬뽕("짬뽕", Category.CHINA),
    마파두부("마파두부", Category.CHINA),
    탕수육("탕수육", Category.CHINA),
    토마토_달걀볶음("토마토 달걀볶음", Category.CHINA),
    고추잡채("고추잡채", Category.CHINA),

    // ASIAN
    팟타이("팟타이", Category.ASIAN),
    카오_팟("카오 팟", Category.ASIAN),
    나시고렝("나시고렝", Category.ASIAN),
    파인애플_볶음밥("파인애플 볶음밥", Category.ASIAN),
    쌀국수("쌀국수", Category.ASIAN),
    똠얌꿍("똠얌꿍", Category.ASIAN),
    반미("반미", Category.ASIAN),
    월남쌈("월남쌈", Category.ASIAN),
    분짜("분짜", Category.ASIAN),

    // AMERICA
    라자냐("라자냐", Category.AMERICA),
    그라탱("그라탱", Category.AMERICA),
    뇨끼("뇨끼", Category.AMERICA),
    끼슈("끼슈", Category.AMERICA),
    프렌치_토스트("프렌치 토스트", Category.AMERICA),
    바게트("바게트", Category.AMERICA),
    스파게티("스파게티", Category.AMERICA),
    피자("피자", Category.AMERICA),
    파니니("파니니", Category.AMERICA);

    private final String alias;
    private final Category category;

    Food(String alias, Category category) {
        this.alias = alias;
        this.category = category;
    }

    public static Food from(String name) {
        for (Food value : values()) {
            if (value.alias.equals(name)) {
                return value;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.FOOD_NOT_EXIST.getMessage());
    }

    public static List<String> getFoodByCategoryAndCouch(Category category, Coach coach) {
        return Arrays.stream(values())
                .filter(value -> value.category == category)
                .filter(value -> !coach.isDeny(value))
                .map(value -> value.alias)
                .collect(Collectors.toList());
    }

    public String getAlias() {
        return alias;
    }
}
