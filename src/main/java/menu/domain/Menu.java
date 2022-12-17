package menu.domain;

import java.util.Arrays;

public enum Menu {
    JAPANESE1("규동"),
    JAPANESE2("우동"),
    JAPANESE3("미소시루"),
    JAPANESE4("스시"),
    JAPANESE5("가츠동"),
    JAPANESE6("오니기리"),
    JAPANESE7("하이라이스"),
    JAPANESE8("라멘"),
    JAPANESE9("오코노미야끼"),

    KOREAN1("김밥"),
    KOREAN2("김치찌개"),
    KOREAN3("쌈밥"),
    KOREAN4("된장찌개"),
    KOREAN5("비빔밥"),
    KOREAN6("칼국수"),
    KOREAN7("불고기"),
    KOREAN8("떡볶이"),
    KOREAN9("제육볶음"),

    CHINESE1("깐풍기"),
    CHINESE2("볶음면"),
    CHINESE3("동파육"),
    CHINESE4("짜장면"),
    CHINESE5("짬뽕"),
    CHINESE6("마파두부"),
    CHINESE7("탕수육"),
    CHINESE8("토마토 달걀볶음"),
    CHINESE9("고추잡채"),

    ASIAN1("팟타이"),
    ASIAN2("카오"),
    ASIAN3("팟"),
    ASIAN4("나시고렝"),
    ASIAN5("파인애플 볶음밥"),
    ASIAN6("쌀국수"),
    ASIAN7("똠양꿍"),
    ASIAN8("반미"),
    ASIAN9("월남쌈"),
    ASIAN10("분짜"),

    AMERICAN1("라자냐"),
    AMERICAN2("그라탱"),
    AMERICAN3("뇨끼"),
    AMERICAN4("끼슈"),
    AMERICAN5("프렌치 토스트"),
    AMERICAN6("바게트"),
    AMERICAN7("스파게티"),
    AMERICAN8("피자"),
    AMERICAN9("파니니");

    private final String menuName;

    Menu(String menuName) {
        this.menuName = menuName;
    }

    public static Menu map(String input) {
        return Arrays.stream(values())
                .filter(menu -> menu.menuName.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
    }
}
