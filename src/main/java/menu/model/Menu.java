package menu.model;

public enum Menu {

    JAPAN_ONE("규동"),
    JAPAN_TWO("우동"),
    JAPAN_THREE("미소시루"),
    JAPAN_FOUR("스시"),
    JAPAN_FIVE("가츠동"),
    JAPAN_SIX("오니기리"),
    JAPAN_SEVEN("하이라이스"),
    JAPAN_EIGHT("라멘"),
    JAPAN_NINE("오꼬노모야끼"),

    KOREA_ONE("김밥"),
    KOREA_TWO("김치찌개"),
    KOREA_THREE("쌈밥"),
    KOREA_FOUR("된장찌개"),
    KOREA_FIVE("비빔밥"),
    KOREA_SIX("칼국수"),
    KOREA_SEVEN("불고기"),
    KOREA_EIGHT("떡볶이"),
    KOREA_NINE("제육볶음"),

    CHINA_ONE("깐풍기"),
    CHINA_TWO("볶음면"),
    CHINA_THREE("동파육"),
    CHINA_FOUR("짜장면"),
    CHINA_FIVE("짬뽕"),
    CHINA_SIX("마파두부"),
    CHINA_SEVEN("탕수육"),
    CHINA_EIGHT("토마토"),
    CHINA_NINE("달걀볶음"),
    CHINA_TEN("고추잡채"),

    ASIA_ONE("팟타이"),
    ASIA_TWO("카오 팟"),
    ASIA_THREE("나시고렝"),
    ASIA_FOUR("파인애플 볶음밥"),
    ASIA_FIVE("쌀국수"),
    ASIA_SIX("똠얌꿍"),
    ASIA_SEVEN("반미"),
    ASIA_EIGHT("월남쌈"),
    ASIA_NINE("분짜"),

    WESTERN_ONE("라자냐"),
    WESTERN_TWO("그라탱"),
    WESTERN_THREE("뇨끼"),
    WESTERN_FOUR("끼슈"),
    WESTERN_FIVE("프렌치 토스트"),
    WESTERN_SIX("바게트"),
    WESTERN_SEVEN("스파게티"),
    WESTERN_EIGHT("피자"),
    WESTERN_NINE("파니니");

    private String name;

    Menu(String name) {
        this.name = name;
    }


}
