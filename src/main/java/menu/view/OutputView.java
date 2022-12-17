package menu.view;


import menu.entity.Category;
import menu.dto.SuggestMenuResultDto;

import java.util.List;

public class OutputView {

    private static final OutputView instance = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printResult(SuggestMenuResultDto dto) {
        System.out.println("메뉴 추천 결과입니다.");
        List<Category> categories = dto.getCategories();

        printCategory(categories);
        printCoachMenu(dto);

        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }

    private void printCoachMenu(SuggestMenuResultDto dto) {
        List<String> coachNames = dto.getCoachNames();
        for (int i = 0; i < coachNames.size(); i++){
            printMenu(coachNames.get(i), dto.getCoachWeeklyMenu().get(i));
        }
    }

    private void printMenu(String coachName, List<String> menuList) {
        System.out.println("[ "
                + coachName + " | "
                + menuList.get(0) + " | "
                + menuList.get(1) + " | "
                + menuList.get(2) + " | "
                + menuList.get(3) + " | "
                + menuList.get(4) + " ]"
        );
    }

    private void printCategory(List<Category> categories) {
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n" +
                "[ 카테고리 | "
                + categories.get(0).getCategoryName() + " | "
                + categories.get(1).getCategoryName() + " | "
                + categories.get(2).getCategoryName() + " | "
                + categories.get(3).getCategoryName() + " | "
                + categories.get(4).getCategoryName() + " ]");
    }

    public void helloMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }
}
