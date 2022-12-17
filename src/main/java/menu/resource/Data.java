package menu.resource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Food;
import menu.domain.FoodRepository;

public class Data {
    private static final int FOODS_INDEX = 1;
    private static final String CATEGORY_DELIMITER = ":";
    private static final String FOOD_DELIMITER = ",";

    private static final Category japanese = Category.JAPANESE;
    private static final Category korean = Category.KOREAN;
    private static final Category chinese = Category.CHINESE;
    private static final Category asian = Category.ASIAN;
    private static final Category western = Category.WESTERN;


    public static void loadData() {
        String japaneseData = "일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼";
        for (String foodName: parsingFoodName(japaneseData)) {
            FoodRepository.addFood(new Food(foodName, japanese));
        }
        String koreanData = "한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음";
        for (String foodName: parsingFoodName(koreanData)) {
            FoodRepository.addFood(new Food(foodName, korean));
        }
        String chineseData = "중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채";
        for (String foodName: parsingFoodName(chineseData)) {
            FoodRepository.addFood(new Food(foodName, chinese));
        }
        String asianData = "아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜";
        for (String foodName: parsingFoodName(asianData)) {
            FoodRepository.addFood(new Food(foodName, asian));
        }
        String westernData = "양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니";
        for (String foodName: parsingFoodName(westernData)) {
            FoodRepository.addFood(new Food(foodName, western));
        }
    }

    private static List<String> parsingFoodName(String rawData) {
        List<String> data = Arrays.asList(rawData.split(CATEGORY_DELIMITER));
        List<String> foods = Arrays.asList(data.get(FOODS_INDEX).split(FOOD_DELIMITER));
        return foods.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
