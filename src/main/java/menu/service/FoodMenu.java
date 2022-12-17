package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.category.Category;
import menu.domain.coach.Coach;

public class FoodMenu {

    private final Map<Category, List<String>> foodMenu;

    public FoodMenu() {
        this.foodMenu = new HashMap<>();
    }

    public void setMenu() {
        setJapanese();

        setKorean();

        setChinese();

        setAsian();

        setWestern();
    }

    private void setJapanese() {
        foodMenu.put(Category.JAPANESE,
            Arrays.asList("규동", "우동", "미소시루",
                "스시", "가츠동", "오니기리",
                "하이라이스", "라멘", "오코노미야끼"));
    }

    private void setKorean() {
        foodMenu.put(Category.KOREAN,
            Arrays.asList("김밥", "김치찌개", "쌈밥",
                "된장찌개", "비빔밥", "칼국수",
                "불고기", "떡볶이", "제육볶음"));
    }

    private void setChinese() {
        foodMenu.put(Category.CHINESE,
            Arrays.asList("깐풍기", "볶음면", "동파육",
                "짜장면", "짬뽕", "마파두부",
                "탕수육", "토마토 달걀볶음", "고추잡채"));
    }

    private void setAsian() {
        foodMenu.put(Category.ASIAN,
            Arrays.asList("팟타이", "카오 팟", "나시고렝",
                "파인애플 볶음밥", "쌀국수", "똠얌꿍",
                "반미", "월남쌈", "분짜"));
    }

    private void setWestern() {
        foodMenu.put(Category.WESTERN,
            Arrays.asList("라자냐", "그라탱", "뇨끼",
                "끼슈", "프렌치 토스트", "바게트",
                "스파게티", "피자", "파니니"));
    }

    public String getRandomMenuWithoutHates(Category category, Coach coach, LunchSuggestion lunchSuggestion) {
        String food = Randoms.shuffle(foodMenu.get(category)).get(0);
        while (coach.isUnEatables(food) && !lunchSuggestion.sameFoodInWeek(coach, food)){
            food = Randoms.shuffle(foodMenu.get(category)).get(0);
        }
        return food;
    }
}
