package menu.domain.factory;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.category.Category;
import menu.domain.menu.Menu;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuCreator {
    private static final Map<Category, String> CATEGORY_MATCHER;
    
    static {
        CATEGORY_MATCHER = new EnumMap<>(Category.class);
        CATEGORY_MATCHER.put(Category.JAPANESE_FOOD, "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼");
        CATEGORY_MATCHER.put(Category.KOREAN_FOOD, "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음");
        CATEGORY_MATCHER.put(Category.CHINESE_FOOD, "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채");
        CATEGORY_MATCHER.put(Category.ASIAN_FOOD, "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜");
        CATEGORY_MATCHER.put(Category.WESTERN_FOOD, "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니");
    }
    
    public static List<Menu> from(Category category) {
        return Randoms.shuffle(parseMenus(category)).stream()
                .map(menuName -> new Menu(menuName, category))
                .collect(Collectors.toUnmodifiableList());
    }
    
    private static List<String> parseMenus(Category category) {
        return Arrays.stream(CATEGORY_MATCHER.get(category).split(", "))
                .collect(Collectors.toUnmodifiableList());
    }
}
