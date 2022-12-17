package menu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import menu.util.StringParser;

public class MenuRepository {
    private static final String JAPANESE = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼";
    private static final String KOREANS = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음";
    private static final String CHINESE = "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채";
    private static final String ASIAN = "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜";
    private static final String WESTERN = "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니";
    private final List<Menu> menus;

    public MenuRepository(List<Menu> menus) {
        this.menus = new ArrayList<>();
    }

    public void readMenu() {
        List<String> menuList = List.of(JAPANESE, KOREANS, CHINESE, ASIAN, WESTERN);
        for (int i = 0; i < Category.values().length; i++) {
            List<String> tmpMenus = StringParser.parseByCommand(menuList.get(i), ",");
            int index = i + 1;
            tmpMenus.stream()
                    .map(v -> new Menu(v, Category.byNumber(index)))
                    .forEach(menus::add);
        }
    }

    public List<String> getMenuNames() {
        return menus.stream()
                .map(Menu::getName)
                .collect(Collectors.toList());
    }

    public Menu getMenuByName(String name) {
        return menus.stream()
                .filter(v -> v.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 없는 메뉴입니다."));
    }
}
