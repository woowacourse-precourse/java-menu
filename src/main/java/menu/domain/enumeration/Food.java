package menu.domain.enumeration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Food {
    KYUDONG(1, "규동"),
    WOODONG(1, "우동"),
    MISOSIROO(1,"미소시루"),
    SHUSHI(1,"스시"),
    KACHEDONG(1,"가츠동"),
    ONIGIRI(1,"오니기리"),
    HIRICE(1,"하이라이스"),
    RAMEN(1,"라멘"),
    OKONOMI(1,"오코노미야끼"),

    KIMBAB(2,"김밥"),
    KIMCHI_STEW(2,"김치찌개"),
    SAMBAB(2,"쌈밥"),
    BEAN_STEW(2,"된장찌개"),
    BIBIMBAB(2,"비빔밥"),
    KALNOODLE(2,"칼국수"),
    BULLMEET(2,"불고기"),
    TUKBOKKI(2,"떡볶이"),
    JEYUKPORK(2,"제육볶음"),

    FRIEDCHICKEN(3,"깐풍기"),
    FRIEDNOODLE(3,"볶음면"),
    DONGPAMEET(3,"동파육"),
    JAJANGNOODLE(3,"짜장면"),
    JJANGBBONG(3,"짬뽕"),
    MAPATOFU(3,"마파두부"),
    FRIEDPORK(3,"탕수육"),
    FRIEDTOMATO(3,"토마토 달걀볶음"),
    PEPPERJAPCHAE(3,"고추잡채"),

    PADTHAI(4,"팟타이"),
    KAOPOD(4,"카오 팟"),
    NASHIGOLANG(4,"나시고렝"),
    PINEAPPLERICE(4,"파인애플 볶음밥"),
    RICENOODLE(4,"쌀국수"),
    TOMYUMGOONG(4,"똠얌꿍"),
    BANMI(4,"반미"),
    WALLNAM(4,"월남쌈"),
    BUNJJA(4,"분짜"),

    LASAGNA(5,"라자냐"),
    GRATIN(5,"그라탱"),
    NYOKKI(5,"뇨끼"),
    KKISWO(5,"끼슈"),
    FRENCHTOAST(5,"프렌치 토스트"),
    BARKET(5,"바게트"),
    SPAGHETTI(5,"스파게티"),
    PIZZA(5,"피자"),
    PHANINI(5,"파니니");

    private final String foodName;
    private final Integer categoryIndex;

    Food(Integer categoryIndex, String foodName) {
        this.foodName = foodName;
        this.categoryIndex = categoryIndex;
    }

    public static List<String> findFoodPerCategory(Integer categoryIndex){
        return Arrays.stream(Food.values())
                .filter(food -> food.categoryIndex.equals(categoryIndex))
                .map(Food::getFoodName)
                .collect(Collectors.toList());
    }

    public String getFoodName() {
        return this.foodName;
    }

    public Integer getCategoryIndex() {
        return this.categoryIndex;
    }

    public static Food[] getAllFood() {
        return Food.values();
    }
}
