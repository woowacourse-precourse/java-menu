package menu.domain.repository;

import menu.domain.model.Category;
import menu.domain.model.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuCreator {

    public static List<Menu> create() {
        List<Menu> menus = new ArrayList<>();
        List<Menu> japanFoods = createJapanFoods();
        List<Menu> koreanFoods = createKoreanFoods();
        List<Menu> chinaFoods = createChinaFoods();
        List<Menu> asiaFoods = createAsiaFoods();
        List<Menu> europeFoods = createEuropeFoods();

        menus.addAll(japanFoods);
        menus.addAll(koreanFoods);
        menus.addAll(chinaFoods);
        menus.addAll(asiaFoods);
        menus.addAll(europeFoods);
        return menus;
    }

    private static List<Menu> createJapanFoods() {
        return List.of(
                new Menu(Category.JAPAN_FOOD, "규동"),
                new Menu(Category.JAPAN_FOOD, "우동"),
                new Menu(Category.JAPAN_FOOD, "미소시루"),
                new Menu(Category.JAPAN_FOOD, "스시"),
                new Menu(Category.JAPAN_FOOD, "가츠동"),
                new Menu(Category.JAPAN_FOOD, "오니기리"),
                new Menu(Category.JAPAN_FOOD, "하이라이스"),
                new Menu(Category.JAPAN_FOOD, "라멘"),
                new Menu(Category.JAPAN_FOOD, "오코노미야끼")
        );
    }

    private static List<Menu> createKoreanFoods() {
        return List.of(
                new Menu(Category.KOREA_FOOD, "김밥"),
                new Menu(Category.KOREA_FOOD, "김치찌개"),
                new Menu(Category.KOREA_FOOD, "쌈밥"),
                new Menu(Category.KOREA_FOOD, "된장찌개"),
                new Menu(Category.KOREA_FOOD, "비빔밥"),
                new Menu(Category.KOREA_FOOD, "칼국수"),
                new Menu(Category.KOREA_FOOD, "불고기"),
                new Menu(Category.KOREA_FOOD, "떡볶이"),
                new Menu(Category.KOREA_FOOD, "제육볶음")
        );
    }

    private static List<Menu> createChinaFoods() {
        return List.of(
                new Menu(Category.CHINA_FOOD, "깐풍기"),
                new Menu(Category.CHINA_FOOD, "볶음면"),
                new Menu(Category.CHINA_FOOD, "동파육"),
                new Menu(Category.CHINA_FOOD, "짜장면"),
                new Menu(Category.CHINA_FOOD, "짬뽕"),
                new Menu(Category.CHINA_FOOD, "마파두부"),
                new Menu(Category.CHINA_FOOD, "탕수육"),
                new Menu(Category.CHINA_FOOD, "토마토 달걀볶음"),
                new Menu(Category.CHINA_FOOD, "고추잡채")
        );
    }

    private static List<Menu> createAsiaFoods() {
        return List.of(
                new Menu(Category.ASIA_FOOD, "팟타이"),
                new Menu(Category.ASIA_FOOD, "카오 팟"),
                new Menu(Category.ASIA_FOOD, "나시고렝"),
                new Menu(Category.ASIA_FOOD, "파인애플 볶음밥"),
                new Menu(Category.ASIA_FOOD, "쌀국수"),
                new Menu(Category.ASIA_FOOD, "똠얌꿍"),
                new Menu(Category.ASIA_FOOD, "반미"),
                new Menu(Category.ASIA_FOOD, "월남쌈"),
                new Menu(Category.ASIA_FOOD, "분짜")
        );
    }

    private static List<Menu> createEuropeFoods() {
        return List.of(
                new Menu(Category.EUROPE_FOOD, "라자냐"),
                new Menu(Category.EUROPE_FOOD, "그라탱"),
                new Menu(Category.EUROPE_FOOD, "뇨끼"),
                new Menu(Category.EUROPE_FOOD, "끼슈"),
                new Menu(Category.EUROPE_FOOD, "프렌치 토스트"),
                new Menu(Category.EUROPE_FOOD, "바게트"),
                new Menu(Category.EUROPE_FOOD, "스파게티"),
                new Menu(Category.EUROPE_FOOD, "피자"),
                new Menu(Category.EUROPE_FOOD, "파니니")
        );
    }
}
