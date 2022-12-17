package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public enum FoodInformation {
    JAPANESE(1, Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN(2, Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE(3, Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN(4, Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN(5,Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private int category;
    private List<String> menu;
    FoodInformation(int category, List<String> menu){
        this.category = category;
        this.menu = menu;
    }

    public static boolean isExist(String foodName){
        return JAPANESE.menu.contains(foodName) || KOREAN.menu.contains(foodName) || CHINESE.menu.contains(foodName)
                || ASIAN.menu.contains(foodName) || WESTERN.menu.contains(foodName);
    }

    public int getCategory(){
        return category;
    }

    public static FoodInformation getRandomCategory(){
        int category = Randoms.pickNumberInRange(1, 5);
        return Arrays.stream(FoodInformation.values())
                .filter(foodInformation -> foodInformation.category == category)
                .findFirst()
                .get();
    }

    public static String getRandomFood(FoodInformation category){
        return Randoms.shuffle(category.menu).get(0);
    }
}
