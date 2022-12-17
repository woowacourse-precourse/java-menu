package menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryMap {
    private final Map<String, List<String>> foodCategoryMap;

    public CategoryMap(Map<String, List<String>> foodCategoryMap) {
        this.foodCategoryMap = initializeCategoryMap();
    }

    public Map<String, List<String>> initializeCategoryMap() {
        Map<String, List<String>> initFoodCategory = new HashMap<>();
        initFoodCategory.put("일식", List.of("규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼"));
        initFoodCategory.put("한식", List.of("김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음"));
        initFoodCategory.put("중식", List.of("깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채"));
        initFoodCategory.put("아시안", List.of("팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜"));
        initFoodCategory.put("양식", List.of("라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니"));
        return initFoodCategory;
    }

}
