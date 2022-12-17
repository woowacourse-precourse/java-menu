package menu.model.constants;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2022. 12. 17.
 */

public enum Menu {

    JAPANESE_FOOD(1, "일식", "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼"),
    KOREAN_FOOD(2, "한식","김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음"),
    CHINESE_FOOD(3, "중식","깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채"),
    ASIAN_FOOD(4, "아시안","팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜"),
    WESTERN_FOOD(5, "양식","라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니");

    private final Integer menuNumber;
    private final String menuCategory;
    private final String menu;

    Menu(Integer menuNumber, String menuCategory, String menu) {
        this.menuNumber = menuNumber;
        this.menuCategory = menuCategory;
        this.menu = menu;
    }

    public Integer getMenuNumber() {
        return menuNumber;
    }

    public String getMenuCategory() {
        return menuCategory;
    }

    public String getMenu() {
        return menu;
    }

    public static String getRandomCategoryWeek(List<String> categories) {
        while (categories.size() != 5) {
            String category = getRandomCategory();
            if (categories.size() < 3) {
                return category;
            }
            if (!isCategoryListIn2(categories, category)) {
                return category;
            }
        }
        return null;
    }

    public static String getRandomCategory() {
        int randomNumber = Randoms.pickNumberInRange(1, 5);
        for (Menu menu : Menu.values()) {
            if (menu.getMenuNumber() == randomNumber) {
                return menu.getMenuCategory();
            }
        }
        return null;
    }

    private static boolean isCategoryListIn2(List<String> categories, String category) {
        int cnt = 0;
        for (String menuCategory : categories) {
            if (menuCategory.equals(category)) {
                cnt++;
            }
        }
        return cnt == 2;
    }
}
