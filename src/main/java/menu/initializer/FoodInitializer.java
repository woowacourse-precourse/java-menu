package menu.initializer;

import menu.domain.AsianFood;
import menu.domain.ChineseFood;
import menu.domain.Food;
import menu.domain.FoodCategory;
import menu.domain.FoodRepository;
import menu.domain.JapaneseFood;
import menu.domain.KoreanFood;
import menu.domain.WesternFood;

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
        for (KoreanFood koreanFood : KoreanFood.values()) {
            FoodRepository.addFood(new Food(korean, koreanFood.getName()));
        }
    }

    private static void initializeChinese() {
        FoodCategory chinese = FoodCategory.CHINESE;
        for (ChineseFood chineseFood : ChineseFood.values()) {
            FoodRepository.addFood(new Food(chinese, chineseFood.getName()));
        }
    }

    private static void initializeAsian() {
        FoodCategory asian = FoodCategory.ASIAN;
        for (AsianFood asianFood : AsianFood.values()) {
            FoodRepository.addFood(new Food(asian, asianFood.getName()));
        }
    }

    private static void initializeWestern() {
        FoodCategory western = FoodCategory.WESTERN;
        for (WesternFood westernFood : WesternFood.values()) {
            FoodRepository.addFood(new Food(western, westernFood.getName()));
        }
    }
}
