package menu.domain.menu;

import menu.domain.category.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRepository {
    private static final List<Menu> menus;
    
    static {
        menus = new ArrayList<>();
        String menuNames = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼";
        menus.addAll(parseMenus(menuNames, Category.JAPANESE_FOOD));
        menuNames = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음";
        menus.addAll(parseMenus(menuNames, Category.KOREAN_FOOD));
        menuNames = "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채";
        menus.addAll(parseMenus(menuNames, Category.CHINESE_FOOD));
        menuNames = "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜";
        menus.addAll(parseMenus(menuNames, Category.ASIAN_FOOD));
        menuNames = "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니";
        menus.addAll(parseMenus(menuNames, Category.WESTERN_FOOD));
    }
    
    private static List<Menu> parseMenus(String menuNames, Category category) {
        return Arrays.stream(menuNames.split(", "))
                .map(menuName -> new Menu(menuName, category))
                .collect(Collectors.toUnmodifiableList());
    }
    
    public static Menu findByMenuName(String menuName) {
        return menus.stream()
                .filter(menu -> menu.isSameMenuName(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴입니다."));
    }
}
