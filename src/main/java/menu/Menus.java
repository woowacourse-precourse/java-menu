package menu;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    private static List<Menu> menus = new ArrayList<>();

    public static void init() {
        String foodList = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼";
        menus.add(new Menu("일식",List.of(foodList.split(", "))));
        foodList = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음";
        menus.add(new Menu("한식",List.of(foodList.split(", "))));
        foodList = "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채";
        menus.add(new Menu("중식",List.of(foodList.split(", "))));
        foodList = "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜";
        menus.add(new Menu("아시안",List.of(foodList.split(", "))));
        foodList = "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니";
        menus.add(new Menu("양식",List.of(foodList.split(", "))));
    }

    public static List<Menu> getMenus() {
        return menus;
    }

    public static Menu getMenuByCategory(String category) {
        return menus.stream()
                .filter(menu -> menu.getCategory().equals(category))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 잘못된 카테고리 입니다."));
    }
}
