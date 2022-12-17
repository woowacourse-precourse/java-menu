package menu.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Menu;
import menu.repository.MenuRepository;

public class MenuController {
    private static final Map<Category, String> INIT_MENUS_INFO = new HashMap<>();
    private static final String MENU_DELIMITER = ", ";

    static {
        INIT_MENUS_INFO.put(Category.JAPAN, "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼");
        INIT_MENUS_INFO.put(Category.KOREA, "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음");
        INIT_MENUS_INFO.put(Category.CHINA, "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채");
        INIT_MENUS_INFO.put(Category.ASIAN, "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜");
        INIT_MENUS_INFO.put(Category.WESTERN, "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니");
    }


    public void initMenu() {
        INIT_MENUS_INFO.entrySet().stream()
                .forEach(entry -> parseMenus(entry.getKey(), entry.getValue()));
    }


    private void parseMenus(Category category, String menus) {
        List<String> parsedMenu = Arrays.stream(menus.split(MENU_DELIMITER)).collect(Collectors.toList());
        for (String menuName : parsedMenu) {
            Menu menu = new Menu(menuName, category);
            MenuRepository.add(menu);
            category.addMenu(menu);
        }
    }
}
