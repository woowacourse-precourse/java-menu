package menu.model.init;

import menu.model.MenuCategory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum InitData {
    JAPAN(MenuCategory.JAPAN, "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼"),
    KOREA(MenuCategory.KOREA, "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음"),
    CHINA(MenuCategory.CHINA, "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채"),
    ASIA(MenuCategory.ASIAN, "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜"),
    AMERICA(MenuCategory.AMERICAN, "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니");


    private final MenuCategory menuCategory;
    private final String menuList;

    InitData(MenuCategory menuCategory, String menuList) {
        this.menuCategory = menuCategory;
        this.menuList = menuList;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public List<String> toList() {
        return Arrays.stream(menuList.split(","))
                .collect(Collectors.toList());
    }
}
