package menu.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodMenu {

    private final Map<Category, List<Food>> foodMenu;

    public FoodMenu() {
        this.foodMenu = new HashMap<>();
    }

    public void setMenu() {
        foodMenu.put(Category.JAPANESE,
            Arrays.asList(new Food("규동"), new Food("우동"), new Food("미소시루"),
                new Food("스시"), new Food("가츠동"), new Food("오니기리"),
                new Food("하이라이스"), new Food("라멘"), new Food("오코노미야끼")));

        foodMenu.put(Category.KOREAN,
            Arrays.asList(new Food("김밥"), new Food("김치찌개"), new Food("쌈밥"),
                new Food("된장찌개"), new Food("비빔밥"), new Food("칼국수"),
                new Food("불고기"), new Food("떡볶이"), new Food("제육볶음")));

        foodMenu.put(Category.CHINESE,
            Arrays.asList(new Food("깐풍기"), new Food("볶음면"), new Food("동파육"),
                new Food("짜장면"), new Food("짬뽕"), new Food("마파두부"),
                new Food("탕수육"), new Food("토마토 달걀볶음"), new Food("고추잡채")));

        foodMenu.put(Category.ASIAN,
            Arrays.asList(new Food("팟타이"), new Food("카오 팟"), new Food("나시고렝"),
                new Food("파인애플 볶음밥"), new Food("쌀국수"), new Food("똠얌꿍"),
                new Food("반미"), new Food("월남쌈"), new Food("분짜")));

        foodMenu.put(Category.WESTERN,
            Arrays.asList(new Food("라자냐"), new Food("그라탱"), new Food("뇨끼"),
                new Food("끼슈"), new Food("프렌치 토스트"), new Food("바게트"),
                new Food("스파게티"), new Food("피자"), new Food("파니니")));
    }
}
