package menu.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import menu.controller.Controller;
import menu.domain.Food;
import menu.domain.FoodRepository;
import menu.exceptionHandler.ExceptionHandler;

public enum Category {

    JAPANESE("일식", new FoodRepository(getFoods(
            List.of("규동", "우동", "미소시루", "스시", "가츠동",
                    "오니기리", "하이라이스", "라멘", "오코노미야끼")
    )), Controller -> {}),
    KOREAN("한식", new FoodRepository(getFoods(List.of(
            "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기",
            "떡볶이", "제육볶음"
    ))), Controller -> {}),
    CHINESE("중식", new FoodRepository(getFoods(List.of(
            "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육",
            "토마토 달걀볶음", "고추잡채"
    ))), Controller -> {}),
    ASIAN("아시안", new FoodRepository(getFoods(List.of(
                    "팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수",
                    "똠얌꿍", "반미", "월남쌈", "분짜"
    ))), Controller -> {}),
    EUROPEAN("양식", new FoodRepository(getFoods(List.of(
            "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트",
            "스파게티", "피자", "파니니"
    ))), Controller -> {});

    private final String name;
    private final FoodRepository foodRepository;
    private final Consumer<Controller> consumer;

    Category(String name, FoodRepository foodRepository, Consumer<Controller> consumer) {
        this.name = name;
        this.foodRepository = foodRepository;
        this.consumer = consumer;
    }

    public static Category from(Food food) {
        return Arrays.stream(Category.values())
                .filter(Category -> Category.getRepository().contains(food))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 목록의 음식을 입력해주세요."));
    }

    private static List<Food> getFoods(List<String> names) {
        List<Food> foods = new ArrayList<>(names.size());
        names.forEach(name -> foods.add(new Food(name)));
        return foods;
    }

    public void process(Controller controller) {
        ExceptionHandler.process(consumer, controller);
    }

    public String getName() {
        return name;
    }

    public FoodRepository getRepository() {
        return foodRepository;
    }
}
