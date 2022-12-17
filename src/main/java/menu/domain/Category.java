package menu.domain;

public enum Category {

    JAPANESE("일식", "1",
            new Menus("규동,우동,미소시루,스시,가츠동,오니기리,하이라이스,라멘,오코노미야끼")),

    KOREAN("한식", "2",
            new Menus("김밥,김치찌개,쌈밥,된장찌개,비빔밥,칼국수,불고기,떡볶이,제육볶음")),

    CHINESE("중식", "3",
            new Menus("깐풍기,볶음면,동파육,짜장면,짬뽕,마파두부,탕수육,토마토 달걀볶음,고추잡채")),

    ASIAN("아시안", "4",
            new Menus("팟타이,카오 팟,나시고렝,파인애플 볶음밥,쌀국수,똠얌꿍,반미,월남쌈,분짜")),

    WESTERN("양식", "5",
            new Menus("라자냐,그라탱,뇨끼,끼슈,프렌치 토스트,바게트,스파게티,피자,파니니"));

    private final String name;
    private final String number;
    private final Menus menus;

    Category(String name, String number, Menus menus) {
        this.name = name;
        this.number = number;
        this.menus = menus;
    }

}
