package menu.repository;

import menu.model.MenuCategory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static menu.model.MenuCategory.ASIAN;
import static menu.model.MenuCategory.CHINA;
import static menu.model.MenuCategory.JAPAN;
import static menu.model.MenuCategory.KOREA;
import static menu.model.MenuCategory.WESTERN;

public class MenuRepository {
    private static final Map<MenuCategory, List<String>> menus = new HashMap<>();

    private static final String JAPANESE_FOOD = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼";
    private static final String KOREAN_FOOD = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음";
    private static final String CHINESE_FOOD = "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채";
    private static final String ASIAN_FOOD = "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜";
    private static final String WESTERN_FOOD = "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니";
    private static final String SPACE = " ";
    private static final String NONE = "";
    private static final String COMMA = ",";

    static {
        initializeMenu(JAPAN, JAPANESE_FOOD);
        initializeMenu(KOREA, KOREAN_FOOD);
        initializeMenu(CHINA, CHINESE_FOOD);
        initializeMenu(ASIAN, ASIAN_FOOD);
        initializeMenu(WESTERN, WESTERN_FOOD);
    }

    private static void initializeMenu(final MenuCategory category, final String menuStrings) {
        final String[] splitFood = splitFoodByComma(menuStrings);
        final List<String> foodToList = Arrays.stream(splitFood)
                .collect(Collectors.toList());

        menus.put(category, foodToList);
    }

    private static String[] splitFoodByComma(final String foodStrings) {
        return foodStrings.trim()
                .replaceAll(SPACE, NONE)
                .split(COMMA);
    }

    public List<String> getMenus(final MenuCategory category) {
        return menus.get(category);
    }
}
