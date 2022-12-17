package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum FoodCategory {
    일식(1, "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼"),
    한식(2, "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음"),
    중식(3, "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채"),
    아시안(4, "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜"),
    양식(5, "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니");

    public static final String NOT_EXITING_CATEGORY_NUM_ERROR_MESSAGE = "[ERROR] 해당 번호는 카테고리에 등록되지 않은 번호입니다.";
    public static final String NOT_EXITING_MENU_ERROR_MESSAGE = "[ERROR] 등록 되지 않은 주문 메뉴 입니다.";

    private int categoryNum;
    private List<Menu> menus;

    FoodCategory(int categoryNum, String menuData) {
        this.categoryNum = categoryNum;
        this.menus = getMenuListData(menuData);
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public static FoodCategory of(int categoryNumber) {
        return Arrays.stream(FoodCategory.values())
                .filter(foodCategory -> foodCategory.categoryNum == categoryNumber)
                .findAny()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(NOT_EXITING_CATEGORY_NUM_ERROR_MESSAGE);
                });
    }

    public static Menu getMenuOf(String menuName) {
        FoodCategory targetCategory = Arrays.stream(FoodCategory.values())
                .filter(foodCategory -> foodCategory.containMenu(menuName))
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(NOT_EXITING_MENU_ERROR_MESSAGE);
                });
        return targetCategory.getMenu(menuName);
    }

    public Menu getMenu(String menuName){
        for(Menu menu : menus){
            if(menu.isMenuName(menuName)){
                return menu;
            }
        }
        throw new IllegalArgumentException(NOT_EXITING_MENU_ERROR_MESSAGE);
    }

    private List<Menu> getMenuListData(String menuData) {
        List<String> list = Arrays.asList(menuData.split(","));
        List<Menu> result = new ArrayList<>();
        for (String data : deleteTrim(list)) {
            result.add(new Menu(data));
        }
        return result;
    }

    private List<String> deleteTrim(List<String> datas) {
        List<String> result = new ArrayList<>();
        for (String data : datas) {
            result.add(data.trim());
        }
        return result;
    }

    private boolean containMenu(String menuName){
        for(Menu menu : menus){
            if(menu.isMenuName(menuName)){
                return true;
            }
        }
        return false;
    }

}
