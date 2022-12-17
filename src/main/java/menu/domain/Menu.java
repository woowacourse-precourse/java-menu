package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Menu {
    규동("규동", Category.JAPANESE),
    우동("우동", Category.JAPANESE),
    미소시루("미소시루", Category.JAPANESE),
    스시("스시", Category.JAPANESE),
    가츠동("가츠동", Category.JAPANESE),
    오니기리("오니기리", Category.JAPANESE),
    하이라이스("하이라이스", Category.JAPANESE),
    라멘("라멘", Category.JAPANESE),
    오코노미야끼("오코노미야끼", Category.JAPANESE),
    김밥("김밥", Category.KOREA),
    김치찌개("김치찌개", Category.KOREA),
    쌈밥("쌈밥", Category.KOREA),
    된장찌개("된장찌개", Category.KOREA),
    비빔밥("비빔밥", Category.KOREA),
    칼국수("칼국수", Category.KOREA),
    불고기("불고기", Category.KOREA),
    떡볶이("떡볶이", Category.KOREA),
    제육볶음("제육볶음", Category.KOREA),
    깐풍기("깐풍기", Category.CHINESE),
    볶음면("볶음면", Category.CHINESE),
    동파육("동파육", Category.CHINESE),
    짜장면("짜장면", Category.CHINESE),
    짬뽕("짬뽕", Category.CHINESE),
    마파두부("마파두부", Category.CHINESE),
    탕수육("탕수육", Category.CHINESE),
    토마토_달걀볶음("토마토 달걀볶음", Category.CHINESE),
    고추잡채("고추잡채", Category.CHINESE),
    팟타이("팟타이", Category.ASIAN),
    카오_팟("카오 팟", Category.ASIAN),
    나시고렝("나시고렝", Category.ASIAN),
    파인애플_볶음밥("파인애플 볶음밥", Category.ASIAN),
    쌀국수("쌀국수", Category.ASIAN),
    똠얌꿍("똠얌꿍", Category.ASIAN),
    반미("반미", Category.ASIAN),
    월남쌈("월남쌈", Category.ASIAN),
    분짜("분짜", Category.ASIAN),
    라자냐("라자냐", Category.WEST),
    그라탱("그라탱", Category.WEST),
    뇨끼("뇨끼", Category.WEST),
    끼슈("끼슈", Category.WEST),
    프렌치_토스트("프렌치 토스트", Category.WEST),
    바게트("바게트", Category.WEST),
    스파게티("스파게티", Category.WEST),
    피자("피자", Category.WEST),
    파니니("파니니", Category.WEST);

    private static final String INVALID_MENU_VALUE_MESSAGE = "유효하지 않은 값입니다.";
    private final String name;
    private final Category category;

    Menu(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public static Menu from(String name) {
        return Arrays.stream(values())
                .filter(menu -> menu.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MENU_VALUE_MESSAGE));
    }

    public static List<String> findByCategory(Category category) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.category == category)
                .map(menu -> menu.name)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }
}
