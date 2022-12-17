package menu.config;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Map;
import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.Menus;
import menu.repository.CoachRepository;
import menu.repository.MenuRepository;
import menu.service.CoachService;
import menu.service.MenuService;

public class AppConfig {

    private static final String DELIMITER = ", ";

    private static final Map<Category, String> inputs = Map.of(
            Category.JAPAN,
            "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼",
            Category.KOREA,
            "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음",
            Category.CHINA,
            "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채",
            Category.ASIAN,
            "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜",
            Category.WESTERN,
            "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니"
    );

    public static CoachService coachService() {
        return new CoachService(coachRepository());
    }

    public static MenuService menuService() {
        return new MenuService(menuRepository());
    }

    private static MenuRepository menuRepository() {
        MenuRepository menuRepository = new MenuRepository();
        for (Category category : Category.values()) {
            Menus menus = Arrays.stream(inputs.get(category).split(DELIMITER))
                    .map(Menu::new)
                    .collect(collectingAndThen(toList(), Menus::new));
            menuRepository.save(category, menus);
        }
        return menuRepository;
    }

    private static CoachRepository coachRepository() {
        return new CoachRepository();
    }

}
