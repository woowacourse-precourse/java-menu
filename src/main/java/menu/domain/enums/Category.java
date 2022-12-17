package menu.domain.enums;

import menu.domain.Menu;

import java.util.List;

import static java.lang.String.format;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toUnmodifiableList;

public enum Category {

    JAPANESE(1,
            "일식",
            List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
    ),
    KOREAN(2,
            "한식",
            List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
    ),
    CHINESE(3,
            "중식"
            , List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
    ),
    ASIAN(4,
            "아시안",
            List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")
    ),
    WESTERN(5,
            "양식",
            List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")
    ),
    ;

    private static final String NO_EXIST_CATEGORY_INDEX_FORMAT = "번호[%d]에 해당하는 카테고리가 없습니다.";
    private static final String NO_EXIST_MENU_FORMAT = "음식[%s]이(가) 존재하지 않습니다.";

    private final int number;
    private final List<Menu> menus;
    private final String categoryName;

    Category(int number, String categoryName, List<String> menus) {
        this.number = number;
        this.categoryName = categoryName;
        this.menus = menus.stream()
                .map(it -> new Menu(this, it))
                .collect(toUnmodifiableList());
    }

    public static Category mapByNumber(final int number) {
        return stream(values())
                .filter(it -> it.number == number)
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                format(NO_EXIST_CATEGORY_INDEX_FORMAT, number)));
    }

    private boolean isContainMenu(String name) {
        for (Menu menu : this.menus) {
            if (menu.name().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static Menu mapMenuByName(final String menuName) {
        for (Category category : values()) {
            Menu menu = findMenu(menuName, category);
            if (menu != null) {
                return menu;
            }
        }
        throw new IllegalArgumentException(
                format(NO_EXIST_MENU_FORMAT, menuName));
    }

    private static Menu findMenu(final String menuName,
                                 final Category category) {
        return category.menus.stream()
                .filter(it -> it.name().equals(menuName))
                .findAny()
                .orElse(null);
    }

    public int number() {
        return number;
    }

    public String categoryName() {
        return categoryName;
    }

    public List<String> menuNames() {
        return menus.stream()
                .map(Menu::name)
                .collect(toUnmodifiableList());
    }
}
