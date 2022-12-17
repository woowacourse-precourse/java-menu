package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Menu {
    KYUDONG("규동", Category.JAPANESE),
    UDON("우동", Category.JAPANESE),
    MISOSIRU("미소시루", Category.JAPANESE),
    SUSHI("스시", Category.JAPANESE),
    ONIGIRI("오니기리", Category.JAPANESE),
    HASHED_RICE("하이라이스", Category.JAPANESE),
    RAMEN("라멘", Category.JAPANESE),
    OKONOMIYAKI("오꼬노미야끼", Category.JAPANESE),

    KIMBAP("김밥", Category.KOREAN),
    KIMCHI_SOUP("김치찌개", Category.KOREAN),
    SSAM_BAP("쌈밥", Category.KOREAN),
    BEAN_PASTE_STEW("된장찌개", Category.KOREAN),
    BIBIMBAP("비빔밥", Category.KOREAN),
    KALGUKSU("칼국수", Category.KOREAN),
    BULGOGI("불고기", Category.KOREAN),
    TTEOKBOKKI("떡볶이", Category.KOREAN),
    JEYUK_BOKKEUM("제육볶음", Category.KOREAN),

    KKANPUNGKI("깐풍기", Category.CHINESE),
    STIR_FRIED_NOODLE("볶음면", Category.CHINESE),
    DONGPAYOOK("동파육", Category.CHINESE),
    BLACK_BEAN_SAUCE_NOODLE("짜장면", Category.CHINESE),
    JJAMPPONG("짬뽕", Category.CHINESE),
    MAPA_TOFU("마파두부", Category.CHINESE),
    SWEET_AND_SOUR_PORK("탕수육", Category.CHINESE),
    TOMATO_EGG_BOKKEUM("토마토 달걀볶음", Category.CHINESE),
    GOCHU_JABCHAE("고추잡채", Category.CHINESE),

    PAD_THAI("팟타이", Category.ASIAN),
    KAO_PAD("카오 팟", Category.ASIAN),
    NASI_GORENG("나시고렝", Category.ASIAN),
    PINEAPPLE_FIRED_RICE("파인애플 볶음밥", Category.ASIAN),
    RICE_NOODLE("쌀국수", Category.ASIAN),
    TOM_YUM_GOONG("똠양꿍", Category.ASIAN),
    BAN_MI("반미", Category.ASIAN),
    WOLNAM_SSAM("월남쌈", Category.ASIAN),
    BUN_CCHA("분짜", Category.ASIAN),

    LASAGNA("라자냐", Category.WESTERN),
    GRATIN("그라탱", Category.WESTERN),
    NYOKKI("뇨끼", Category.WESTERN),
    KKISHU("끼슈", Category.WESTERN),
    FRENCH_TOAST("프렌치 토스트", Category.WESTERN),
    BAGUETTE("바게트", Category.WESTERN),
    SPAGHETTI("스파게티", Category.WESTERN),
    PIZZA("피자", Category.WESTERN),
    PANINI("파니니", Category.WESTERN);

    private final String name;
    private final Category category;

    Menu(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public static List<Menu> getMenusByCategory(Category category) {
        return Arrays.stream(values())
                .filter(menu -> menu.category.equals(category))
                .collect(Collectors.toList());
    }
}