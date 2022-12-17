package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Category {
    JAPANESE(1, "일식", "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼"),
    KOREAN(2, "한식", "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음"),
    CHINESE(3, "중식", "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채"),
    ASIAN(4, "아시안", "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜"),
    WESTERN(5, "양식", "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니");

    public static final String INVALID_NUMBER = "올바르지 않은 숫자입니다.";
    public static final String DELIMITER_FOR_MENU = ", ";
    private final int number;
    private final String name;
    private final List<String> menu;

    private static final Map<Integer, Category> numberToCategory = new HashMap<>();

    private static final Map<String, Category> menuToCategory = new HashMap<>();

    static {
        for (Category category : Category.values()) {
            numberToCategory.put(category.number, category);
        }
        for (Category category: Category.values()) {
            for(String menu: category.menu) {
                menuToCategory.put(menu, category);
            }
        }
    }

    public String getName() {
        return name;
    }

    Category(int number, String name, String menuJoinWithDelimiter) {
        this.number = number;
        this.name = name;
        this.menu = Arrays.asList(menuJoinWithDelimiter.split(DELIMITER_FOR_MENU));
    }

    public static Category getCategoryByNumber(int number) {
        if (!numberToCategory.containsKey(number)) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
        return numberToCategory.get(number);
    }

    public static void existsHaving(String menu) {
        if (!menuToCategory.containsKey(menu)) {
            throw new IllegalArgumentException("메뉴에 해당하는 카테고리가 없습니다.");
        }
    }

    public String getRandomMenu() {
        return Randoms.shuffle(menu).get(0);
    }
}
