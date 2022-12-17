package menu.domain;

import java.util.Arrays;

public enum Menu {

    SUSHI("스시",Category.JAPANESE),
    GIMBAP("김밥", Category.KOREAN),
    KIMCHIJJIGAE("김치찌개",Category.KOREAN),
    SSAMBAP("쌈밥", Category.KOREAN),
    DOENJANGJJIGAE("된장찌개", Category.KOREAN),
    JJAMPPONG("짬뽕", Category.CHINESE),
    PHO("쌀국수", Category.ASIAN),
    PIZZA("피자", Category.WESTERN);

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
}
