package menu;

import menu.constant.FoodCategory;
import menu.controller.MainController;
import menu.repository.CategoryRepository;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        MainController mainController = MainController.getInstance();
        initCategory();
        initFoodByCategory();
        mainController.start();
        mainController.registerCoach();
        mainController.registerInedibleFood();
        mainController.recommend();
        mainController.showRecommendations();
        mainController.finish();
    }

    // TODO: 초기화 기능 Repository 로 옮기기
    public static void initCategory() {
        CategoryRepository categoryRepository = CategoryRepository.getInstance();
        categoryRepository.addCategory(FoodCategory.JAPAN.getFoodCategory());
        categoryRepository.addCategory(FoodCategory.KOREA.getFoodCategory());
        categoryRepository.addCategory(FoodCategory.CHINA.getFoodCategory());
        categoryRepository.addCategory(FoodCategory.ASIA.getFoodCategory());
        categoryRepository.addCategory(FoodCategory.WEST.getFoodCategory());
    }

    public static void initFoodByCategory() {
        CategoryRepository categoryRepository = CategoryRepository.getInstance();
        categoryRepository.addFoodToCategory(FoodCategory.JAPAN.getFoodCategory(),
                List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        categoryRepository.addFoodToCategory(FoodCategory.JAPAN.getFoodCategory(),
                List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        categoryRepository.addFoodToCategory(FoodCategory.JAPAN.getFoodCategory(),
                List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        categoryRepository.addFoodToCategory(FoodCategory.JAPAN.getFoodCategory(),
                List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        categoryRepository.addFoodToCategory(FoodCategory.JAPAN.getFoodCategory(),
                List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    }
}
