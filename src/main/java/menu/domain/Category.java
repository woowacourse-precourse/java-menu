package menu.domain;

import static menu.domain.Menu.convertToMenus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.exception.menu.WrongMenuNameException;

public enum Category {
    JAPANESE(1, "일식", "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼"),
    KOREAN(2, "한식", "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음"),
    CHINESE(3, "중식", "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채"),
    ASIAN(4, "아시안", "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜"),
    WESTERN(5, "양식", "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니");

    private static java.util.Collections Collections;
    private int index;
    private String name;
    private List<Menu> menus;

    Category(int index, String name, String menuNames) {
        this.index = index;
        this.name = name;
        this.menus = convertToMenus(this, menuNames);
    }

    public static Category getCategoryByIndex(int index) {
        return Arrays.stream(values())
                .filter(c -> c.index == index)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Menu findMenuByName(String menuName) {
        List<Menu> totalMenu = getTotalMenu();
        return totalMenu.stream()
                .filter(menu -> menu.checkMenuName(menuName)).findAny()
                .orElseThrow(WrongMenuNameException::new);
    }

    public List<String> getMenuNames() {
        return menus.stream().map(Menu::getName).collect(Collectors.toList());
    }

    public static List<Menu> getTotalMenu() {
        List<Menu> totalMenu = new ArrayList<>();
        for (Category category : values()) {
            totalMenu.addAll(category.menus);
        }
        return java.util.Collections.unmodifiableList(totalMenu);
    }

    @Override
    public String toString() {
        return name;
    }
}
