package menu.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Menu;

public class MenuRepository {
    private static final List<Menu> menus = new ArrayList<>();

    static{
        menus.add(new Menu("규동", Category.JAPANESE_FOOD));
        menus.add(new Menu("우동", Category.JAPANESE_FOOD));
        menus.add(new Menu("미소시루", Category.JAPANESE_FOOD));
        menus.add(new Menu("스시", Category.JAPANESE_FOOD));
        menus.add(new Menu("가츠동", Category.JAPANESE_FOOD));
        menus.add(new Menu("오니기리", Category.JAPANESE_FOOD));
        menus.add(new Menu("하이라이스", Category.JAPANESE_FOOD));
        menus.add(new Menu("라멘", Category.JAPANESE_FOOD));
        menus.add(new Menu("오꼬노미야끼", Category.JAPANESE_FOOD));

        menus.add(new Menu("김밥",Category.KOREAN_FOOD));
        menus.add(new Menu("김치찌개",Category.KOREAN_FOOD));
        menus.add(new Menu("쌈밥",Category.KOREAN_FOOD));
        menus.add(new Menu("된장찌개",Category.KOREAN_FOOD));
        menus.add(new Menu("비빕밥",Category.KOREAN_FOOD));
        menus.add(new Menu("칼국수",Category.KOREAN_FOOD));
        menus.add(new Menu("불고기",Category.KOREAN_FOOD));
        menus.add(new Menu("떡볶이",Category.KOREAN_FOOD));
        menus.add(new Menu("제육복음",Category.KOREAN_FOOD));

        menus.add(new Menu("깐풍기",Category.CHINESE_FOOD));
        menus.add(new Menu("볶음면",Category.CHINESE_FOOD));
        menus.add(new Menu("동파육",Category.CHINESE_FOOD));
        menus.add(new Menu("짜장면",Category.CHINESE_FOOD));
        menus.add(new Menu("짬뽕",Category.CHINESE_FOOD));
        menus.add(new Menu("마파두부",Category.CHINESE_FOOD));
        menus.add(new Menu("탕수육",Category.CHINESE_FOOD));
        menus.add(new Menu("토마토 달걍볶음",Category.CHINESE_FOOD));
        menus.add(new Menu("고추잡채",Category.CHINESE_FOOD));

        menus.add(new Menu("팟타이",Category.ASIAN_FOOD));
        menus.add(new Menu("카오 팟",Category.ASIAN_FOOD));
        menus.add(new Menu("나시고렝",Category.ASIAN_FOOD));
        menus.add(new Menu("파인애플 볶음밥",Category.ASIAN_FOOD));
        menus.add(new Menu("쌀국수",Category.ASIAN_FOOD));
        menus.add(new Menu("똠양꿍",Category.ASIAN_FOOD));
        menus.add(new Menu("반미",Category.ASIAN_FOOD));
        menus.add(new Menu("월남쌈",Category.ASIAN_FOOD));
        menus.add(new Menu("분짜",Category.ASIAN_FOOD));

        menus.add(new Menu("라자냐",Category.AMERICAN_FOOD));
        menus.add(new Menu("그라탱",Category.AMERICAN_FOOD));
        menus.add(new Menu("뇨끼",Category.AMERICAN_FOOD));
        menus.add(new Menu("끼슈",Category.AMERICAN_FOOD));
        menus.add(new Menu("프렌치 토스트",Category.AMERICAN_FOOD));
        menus.add(new Menu("바게트",Category.AMERICAN_FOOD));
        menus.add(new Menu("스파게티",Category.AMERICAN_FOOD));
        menus.add(new Menu("피자",Category.AMERICAN_FOOD));
        menus.add(new Menu("파니니",Category.AMERICAN_FOOD));
    }

    public static List<Menu> menus() {
        return Collections.unmodifiableList(menus);
    }

    public static Menu findByMenuName(String name) {
        return menus().stream().filter(menu -> menu.getName().equals(name))
            .findAny()
            .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 메뉴 번호입니다"));
    }

    public static List<Menu> findByMenuCategory(Category category) {
        return menus().stream().filter(menu -> menu.getCategory().equals(category))
            .collect(Collectors.toList());
    }
//    일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
//한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
//중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
//아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
//양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니
}
