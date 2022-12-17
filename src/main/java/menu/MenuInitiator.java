package menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.FoodCategory;
import menu.domain.Menu;
import menu.repository.MenuRepository;

public class MenuInitiator {

    private static final String FOOD_DELIMITER = ",";
    private static final String japaneseFoods = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼";
    private static final String koreanFoods = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음";
    private static final String chineseFoods = "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채";
    private static final String asianFoods = "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜";
    private static final String westernFoods = "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니";

    public static void init() {
        initMenus(FoodCategory.JAPANESE, japaneseFoods);
        initMenus(FoodCategory.KOREAN, koreanFoods);
        initMenus(FoodCategory.CHINESE, chineseFoods);
        initMenus(FoodCategory.ASIAN, asianFoods);
        initMenus(FoodCategory.WESTERN, westernFoods);
    }

    private static void initMenus(FoodCategory foodCategory, String foods) {
        List<Menu> menus = Arrays.stream(foods.split(FOOD_DELIMITER))
            .map(Menu::new)
            .collect(Collectors.toList());
        MenuRepository.save(foodCategory, menus);
    }
}
