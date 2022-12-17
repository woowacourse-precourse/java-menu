package menu.domain;

import java.util.ArrayList;
import java.util.List;

public enum Category {
    JAPAN(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private static final String JAPANESE_MENU = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼";
    private static final String KOREAN_MENU = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음";
    private static final String CHINESE_MENU = "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채";
    private static final String ASIAN_MENU = "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜";
    private static final String WESTERN_MENU = "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니";

    private int number;
    private String name;

    Category(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public static String getNameByNumber(int number) {
        if (number == 1) {
            return JAPAN.name;
        }
        if (number == 2) {
            return KOREAN.name;
        }
        if (number == 3) {
            return CHINESE.name;
        }
        if (number == 4) {
            return ASIAN.name;
        }
        if (number == 5) {
            return WESTERN.name;
        }
        return "카테고리 번호 다시 입력";
    }

    public static List<String> getMenus(int categoryNumber) {
        String categoryName = Category.getNameByNumber(categoryNumber);

        String menu = getMenusByCategoryName(categoryName);

        List<String> menus = stringToList(menu);
        return menus;
    }

    private static String getMenusByCategoryName(String name) {
        if(name.equals("일식")) {
            return JAPANESE_MENU;
        }
        if(name.equals("한식")) {
            return KOREAN_MENU;
        }
        if(name.equals("중식")) {
            return CHINESE_MENU;
        }
        if(name.equals("아시안")) {
            return ASIAN_MENU;
        }
        if(name.equals("양식")) {
            return WESTERN_MENU;
        }

        return "카테고리 이름으로 메뉴 못불러옴";
    }

    private static List<String> stringToList(String menu) {
        List<String> menus = new ArrayList<>();
        String[] splitMenu = menu.split(", ");
        for (int i = 0; i < splitMenu.length; i++) {
            menus.add(splitMenu[i]);
        }

        return menus;
    }
}
