package menu.view;


import menu.Category;
import menu.dto.SuggestMenuResultDto;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final OutputView instance = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printResult(SuggestMenuResultDto dto) {
        List<Category> categories = dto.getCategories();
        Map<String, List<String>> coachWeeklyMenu = dto.getCoachWeeklyMenu();

        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n" +
                "[ 카테고리 | "
                + categories.get(0).getCategoryName() + " | "
                + categories.get(1).getCategoryName() +" | "
                + categories.get(2).getCategoryName() +" | "
                + categories.get(3).getCategoryName() +" | "
                + categories.get(4).getCategoryName() +" ]");
        for(Map.Entry<String, List<String>> entry : coachWeeklyMenu.entrySet()){
            String coachName = entry.getKey();
            List<String> menuList = entry.getValue();

            System.out.println("[ "
                    + coachName +" | "
                    + menuList.get(0) +" | "
                    + menuList.get(1) +" | "
                    + menuList.get(2) +" | "
                    + menuList.get(3) +" | "
                    + menuList.get(4) +" ]"
            );

        }
        System.out.println();

        System.out.println("추천을 완료했습니다.");

//                "[ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]\n" +
//                "[ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ]\n" +
//                "[ 포코 | 된장찌개 | 불고기 | 하이라이스 | 탕수육 | 나시고렝 ]\n" +
//                "\n" +
//                "추천을 완료했습니다.");
    }
}
