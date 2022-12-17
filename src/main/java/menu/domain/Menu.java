package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Menu {

    GYUDONG("규동",Category.JAPANESE),
    WUDONG("우동",Category.JAPANESE),
    MISOSIRU("미소시루",Category.JAPANESE),
    SUSHI("스시",Category.JAPANESE),
    KASUTDONG("가츠동",Category.JAPANESE),
    ONIGIRI("오니기리",Category.JAPANESE),
    HIRICE("하이라이스",Category.JAPANESE),
    RAMEN("라멘",Category.JAPANESE),
    OKONOMIYAKKI("오코노미야끼",Category.JAPANESE),

    GIMBAP("김밥", Category.KOREAN),
    KIMCHIJJIGAE("김치찌개",Category.KOREAN),
    SSAMBAP("쌈밥", Category.KOREAN),
    DOENJANGJJIGAE("된장찌개", Category.KOREAN),
    BIBIMBAP("비빔밥", Category.KOREAN),
    KALGUKSU("칼국수", Category.KOREAN),
    BULGOGI("불고기", Category.KOREAN),
    DDOKBBOGGI("떡볶이", Category.KOREAN),
    JETUGBOOKEUM("제육볶음", Category.KOREAN),


    GGANPUNGI("깐풍기", Category.CHINESE),
    FIRED_NOODLE("볶음면", Category.CHINESE),
    DONGPAYUG("동파육", Category.CHINESE),
    JJAJANGMYONE("짜장면", Category.CHINESE),
    JJAMPPONG("짬뽕", Category.CHINESE),
    MAPADUBU("마파두부", Category.CHINESE),
    TANGSUYUG("탕수육", Category.CHINESE),
    FRIED_TOMATO_WITH_EGG("토마토달걀볶음", Category.CHINESE),
    GOCHUJABCHAE("고추잡채", Category.CHINESE),


    PHAT_THAI("팟타이", Category.ASIAN),
    KHAO_PHAT("카오 팟", Category.ASIAN),
    NASIGOLENG("나시고렝", Category.ASIAN),
    PINEAPPLE_FIRED_RICE("파인애플 볶음밥", Category.ASIAN),
    TOMYUMGOONG("쌀국수", Category.ASIAN),
    PHO("똠양꿍", Category.ASIAN),
    BANMI("반미", Category.ASIAN),
    SPRING_ROLL("월남쌈", Category.ASIAN),
    BUNJJA("분짜", Category.ASIAN),

    LASAGNA("라자냐", Category.WESTERN),
    GRATIN("그라탱", Category.WESTERN),
    GNOCCHI("뇨끼", Category.WESTERN),
    QUICHE("끼슈", Category.WESTERN),
    FRENCH_TOAST("프렌치 토스트", Category.WESTERN),
    SPAGHETTI("스파게티", Category.WESTERN),
    PIZZA("피자", Category.WESTERN),
    PANINI("파니니", Category.WESTERN);

    private final String name;
    private final Category category;

    Menu(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public static Menu of(String input) {
        return Arrays.stream(values())
                .filter(menu -> menu.name.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다. 입력값 : " + input));
    }

    public static Menu createRandomMenuByCategory(Category category) {
        List<Menu> menusBySpecificCategory = Arrays.stream(values())
                .filter(menu -> menu.category.equals(category))
                .collect(Collectors.toList());
        return Randoms.shuffle(menusBySpecificCategory).get(0);
    }

    public String getName() {
        return name;
    }
}
