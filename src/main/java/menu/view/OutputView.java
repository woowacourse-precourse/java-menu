package menu.view;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.RecommendMenuRepository;

import java.util.List;
import java.util.Map;

public class OutputView implements Output {
    String startLine = "[ ";
    String middleLine = " | ";
    String endLine = " ]";

    @Override
    public void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다." + System.lineSeparator());
    }

    @Override
    public void printMenu(RecommendMenuRepository recommendMenuRepository) {
        System.out.println(System.lineSeparator() + "메뉴 추천 결과입니다.");
        System.out.println(System.lineSeparator() + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategory(recommendMenuRepository.categories());
        printRecommendMenu(recommendMenuRepository.recommendMenus());
    }

    private void printRecommendMenu(Map<Coach, List<String>> recommendMenus) {
        for (Coach coach : recommendMenus.keySet()) {
            System.out.println(startLine + coach.name() + middleLine + String.join(middleLine, recommendMenus.get(coach)) + endLine);
        }
    }

    private void printCategory(List<Category> categories) {
        String print = startLine +"카테고리" + middleLine;
        for (Category category : categories) {
            print += category.getName() + middleLine;
        }
        print = print.substring(0, print.length() - 3);
        System.out.println(print + endLine);
    }

    @Override
    public void printEnd() {
        System.out.println(System.lineSeparator() + "추천을 완료했습니다.");
    }
}
