package menu.view;

import menu.model.domain.Category;
import menu.model.domain.Coach;
import menu.model.service.CoachService;
import menu.model.service.FoodService;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final String ERROR = "[ERROR]";

    public static void printErrorMessage(String message) {
        System.out.println(ERROR + " " + message);
    }

    public static void startLunch() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public static void printResult(CoachService coachService, FoodService foodService, List<Category> stringCategoryMap) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.print("[ 카테고리");
        List<String> categoryList = new ArrayList<>();

        for (Category category : stringCategoryMap) {
            System.out.print(" | " + category.getCategory());
        }
        System.out.println(" ]");

        List<String> allNames = coachService.findAllNames();
        for (String name : allNames) {
            Coach coach = coachService.findByName(name);
            System.out.print("[ " + coach.getName());
            for (String foodName : coach.makeLunchMenu()) {
                System.out.print(" | " + foodName);
            }
            System.out.println(" ]");
        }
    }

    /**
     * 메뉴 추천 결과입니다.
     * [ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]
     * [ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]
     * [ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]
     * [ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ]
     * [ 포코 | 된장찌개 | 불고기 | 하이라이스 | 탕수육 | 나시고렝 ]
     *
     * 추천을 완료했습니다.
     */

    public static void finishRecommend() {
        System.out.println("추천을 완료했습니다.");
    }
}

