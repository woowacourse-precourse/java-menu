package menu.initializer;

import menu.domain.Food;
import menu.domain.FoodCategory;
import menu.domain.FoodRepository;
import menu.domain.JapaneseFood;

public class FoodInitializer {
    public static void initializeFood() {
        initializeJapanese();
        initializeKorean();
        initializeChinese();
        initializeAsian();
        initializeWestern();
    }

    private static void initializeJapanese() {
        FoodCategory japanese = FoodCategory.JAPANESE;
        for (JapaneseFood japaneseFood : JapaneseFood.values()) {
            FoodRepository.addFood(new Food(japanese, japaneseFood.getName()));
        }
    }

    private static void initializeKorean() {
        FoodCategory korean = FoodCategory.KOREAN;
        FoodRepository.addFood(new Food(korean, "김밥"));
        FoodRepository.addFood(new Food(korean, "김치찌개"));
        FoodRepository.addFood(new Food(korean, "쌈밥"));
        FoodRepository.addFood(new Food(korean, "된장찌개"));
        FoodRepository.addFood(new Food(korean, "비빔밥"));
        FoodRepository.addFood(new Food(korean, "칼국수"));
        FoodRepository.addFood(new Food(korean, "불고기"));
        FoodRepository.addFood(new Food(korean, "떡볶이"));
        FoodRepository.addFood(new Food(korean, "제육볶음"));
    }

    private static void initializeChinese() {
        FoodCategory chinese = FoodCategory.CHINESE;
        FoodRepository.addFood(new Food(chinese, "깐풍기"));
        FoodRepository.addFood(new Food(chinese, "볶음면"));
        FoodRepository.addFood(new Food(chinese, "동파육"));
        FoodRepository.addFood(new Food(chinese, "짜장면"));
        FoodRepository.addFood(new Food(chinese, "짬뽕"));
        FoodRepository.addFood(new Food(chinese, "마파두부"));
        FoodRepository.addFood(new Food(chinese, "탕수육"));
        FoodRepository.addFood(new Food(chinese, "토마토 달걀볶음"));
        FoodRepository.addFood(new Food(chinese, "고추잡채"));
    }

    private static void initializeAsian() {
        FoodCategory asian = FoodCategory.ASIAN;
        FoodRepository.addFood(new Food(asian, "팟타이"));
        FoodRepository.addFood(new Food(asian, "카오 팟"));
        FoodRepository.addFood(new Food(asian, "나시고렝"));
        FoodRepository.addFood(new Food(asian, "파인애플 볶음밥"));
        FoodRepository.addFood(new Food(asian, "쌀국수"));
        FoodRepository.addFood(new Food(asian, "똠얌꿍"));
        FoodRepository.addFood(new Food(asian, "반미"));
        FoodRepository.addFood(new Food(asian, "월남쌈"));
        FoodRepository.addFood(new Food(asian, "분짜"));
    }

    private static void initializeWestern() {
        FoodCategory western = FoodCategory.WESTERN;
        FoodRepository.addFood(new Food(western, "라자냐"));
        FoodRepository.addFood(new Food(western, "그라탱"));
        FoodRepository.addFood(new Food(western, "뇨끼"));
        FoodRepository.addFood(new Food(western, "끼슈"));
        FoodRepository.addFood(new Food(western, "프렌치 토스트"));
        FoodRepository.addFood(new Food(western, "바게트"));
        FoodRepository.addFood(new Food(western, "스파게티"));
        FoodRepository.addFood(new Food(western, "피자"));
        FoodRepository.addFood(new Food(western, "파니니"));
    }
}
