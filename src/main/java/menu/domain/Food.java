package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.utils.Category;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Food {
    // KOREA
    김밥(Category.KOREA),
    김치찌개(Category.KOREA),
    쌈밥(Category.KOREA),
    된장찌개(Category.KOREA),
    비빔밥(Category.KOREA),
    칼국수(Category.KOREA),
    불고기(Category.KOREA),
    떡볶이(Category.KOREA),
    제육볶음(Category.KOREA),

    // JAPAN
    규동(Category.JAPAN),
    우동(Category.JAPAN),
    미소시루(Category.JAPAN),
    스시(Category.JAPAN),
    가츠동(Category.JAPAN),
    오니기리(Category.JAPAN),
    하이라이스(Category.JAPAN),
    라멘(Category.JAPAN),
    오코노미야끼(Category.JAPAN),

    // CHINA
    깐풍기(Category.CHINA),
    볶음면(Category.CHINA),
    동파육(Category.CHINA),
    짜장면(Category.CHINA),
    짬뽕(Category.CHINA),
    마파두부(Category.CHINA),
    탕수육(Category.CHINA),
    토마토_달걀볶음(Category.CHINA),
    고추잡채(Category.CHINA),

    // ASIAN
    팟타이(Category.ASIAN),
    카오_팟(Category.ASIAN),
    나시고렝(Category.ASIAN),
    파인애플_볶음밥(Category.ASIAN),
    쌀국수(Category.ASIAN),
    똠얌꿍(Category.ASIAN),
    반미(Category.ASIAN),
    월남쌈(Category.ASIAN),
    분짜(Category.ASIAN),

    // AMERICA
    라자냐(Category.AMERICA),
    그라탱(Category.AMERICA),
    뇨끼(Category.AMERICA),
    끼슈(Category.AMERICA),
    프렌치_토스트(Category.AMERICA),
    바게트(Category.AMERICA),
    스파게티(Category.AMERICA),
    피자(Category.AMERICA),
    파니니(Category.AMERICA);

    private final Category category;

    Food(Category category) {
        this.category = category;
    }

    public static Food getFoodByCategoryAndCouch(Category category, Couch couch) {
        List<Food> collect = Arrays.stream(values())
                .filter(value -> value.category == category)
                .filter(value -> !couch.isDeny(value))
                .collect(Collectors.toList());

        return Randoms.shuffle(collect).get(0);
    }
}
