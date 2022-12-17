package menu.domain.menu.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.menu.type.Category;
import menu.domain.menu.model.Food;

public class FoodRepositoryImpl implements FoodRepository {

    private static final List<Food> foods = new ArrayList<>();

    static {
        foods.add(new Food("규동", Category.JAPANESE));
        foods.add(new Food("우동", Category.JAPANESE));
        foods.add(new Food("미소시루", Category.JAPANESE));
        foods.add(new Food("스시", Category.JAPANESE));
        foods.add(new Food("가츠동", Category.JAPANESE));
        foods.add(new Food("오니기리", Category.JAPANESE));
        foods.add(new Food("하이라이스", Category.JAPANESE));
        foods.add(new Food("라멘", Category.JAPANESE));
        foods.add(new Food("오코노미야끼", Category.JAPANESE));

        foods.add(new Food("김밥", Category.KOREAN));
        foods.add(new Food("김치찌개", Category.KOREAN));
        foods.add(new Food("쌈밥", Category.KOREAN));
        foods.add(new Food("된장찌개", Category.KOREAN));
        foods.add(new Food("비빔밥", Category.KOREAN));
        foods.add(new Food("칼국수", Category.KOREAN));
        foods.add(new Food("불고기", Category.KOREAN));
        foods.add(new Food("떡볶이", Category.KOREAN));
        foods.add(new Food("제육볶음", Category.KOREAN));

        foods.add(new Food("깐풍기", Category.CHINESE));
        foods.add(new Food("볶음면", Category.CHINESE));
        foods.add(new Food("동파육", Category.CHINESE));
        foods.add(new Food("짜장면", Category.CHINESE));
        foods.add(new Food("짬뽕", Category.CHINESE));
        foods.add(new Food("마파두부", Category.CHINESE));
        foods.add(new Food("탕수육", Category.CHINESE));
        foods.add(new Food("토마토 달걀볶음", Category.CHINESE));
        foods.add(new Food("고추잡채", Category.CHINESE));

        foods.add(new Food("팟타이", Category.ASIAN));
        foods.add(new Food("카오 팟", Category.ASIAN));
        foods.add(new Food("나시고렝", Category.ASIAN));
        foods.add(new Food("파인애플 볶음밥", Category.ASIAN));
        foods.add(new Food("쌀국수", Category.ASIAN));
        foods.add(new Food("똠얌꿍", Category.ASIAN));
        foods.add(new Food("반미", Category.ASIAN));
        foods.add(new Food("월남쌈", Category.ASIAN));
        foods.add(new Food("분짜", Category.ASIAN));

        foods.add(new Food("라자냐", Category.WESTERN));
        foods.add(new Food("그라탱", Category.WESTERN));
        foods.add(new Food("뇨끼", Category.WESTERN));
        foods.add(new Food("끼슈", Category.WESTERN));
        foods.add(new Food("프렌치 토스트", Category.WESTERN));
        foods.add(new Food("바게트", Category.WESTERN));
        foods.add(new Food("스파게티", Category.WESTERN));
        foods.add(new Food("피자", Category.WESTERN));
        foods.add(new Food("파니니", Category.WESTERN));
    }

    @Override
    public List<Food> findByCategory(Category category) {
        return foods.stream().filter(food -> food.getCategory().equals(category))
            .collect(Collectors.toList());
    }
}
