package menu.domain.enums;

public enum Menu {
    //    규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
    GYUDON("규동"),
    UDON("우동"),
    MISOSORU("미소시루"),
    SUSHI("스시"),
    KATSU_DONG("가츠동"),
    ONIGIRI("오니기리"),
    HIGHRICE("하이라이스"),
    RAMEN("라멘"),
    OKONOMIYAKI("오코노미야끼"),
    // 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
    GIMBAP("김밥"),
    KIMCHI_STEW("김치찌개"),
    SSAMBAP("쌈밥"),
    DOENJANG_STEW("된장찌개"),
    BIBIMBAP("비빔밥"),
    KALGUKSU("칼국수"),
    BULGOGI("불고기"),
    TTEOKBOKKI("떡볶이"),
    STIRFRIED_PORK("제육볶음"),
    // 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
    KKANPUNGGI("깐풍기"),
    STIR_FRIED_NOODLES("볶음면"),
    DONGPAYUK("동파육"),
    JAJANGMYEON("짜장면"),
    JJAMPPONG("짬뽕"),
    MAPA_TOFU("마파두부"),
    TANGSUYUK("탕수육"),
    TOMATO_EGG_STIR_FRIED("토마토 달걀볶음"),
    RED_PEPPER_JAPCHAE("고추잡채"),
    //팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
    PADTHAI("팟타이"),
    KAOPOD("카오 팟"),
    NASIGORENG("나시고렝"),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥"),
    RICE_NOODLES("쌀국수"),
    TOMYUMKUNG("똠얌꿍"),
    BANMI("반미"),
    VIETNAMESE_SPRING_ROLLS("월남쌈"),
    BUNCHA("분짜"),
    //라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니
    LASAGNA("라자냐"),
    GRATIN("그라탱"),
    NYOKI("뇨끼"),
    KISHU("끼슈"),
    FRENCH_TOAST("프렌치 토스트"),
    BAGUETTE("바게트"),
    SPAGHETTI("스파게티"),
    PIZZA("피자"),
    PANINI("파니니");

    private String name;

    Menu(final String name) {
        this.name = name;
    }
}
