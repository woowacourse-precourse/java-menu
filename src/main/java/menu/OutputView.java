package menu;

import menu.domain.Category;
import menu.domain.CategoryRepository;
import menu.domain.Coach;
import menu.domain.CoachRepository;

public class OutputView {
    private static final String DIVISION_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT_MESSAGE = "\n메뉴 추천 결과입니다.";
    private static final String EXIT_MESSAGE = "\n추천을 완료했습니다.";

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printResult() {
        System.out.println(RESULT_MESSAGE);
        System.out.println(DIVISION_MESSAGE);
        printCategoryResult();
        printRecommendResult();
        System.out.println(EXIT_MESSAGE);
    }

    private void printCategoryResult() {
        int index = 0;
        System.out.print("[ 카테고리 |");
        for (Category category : CategoryRepository.categories()) {
            System.out.print(" " + category.getName() + " ");
            if (index < CategoryRepository.categories().size() - 1) {
                System.out.print("|");
            }
            index++;
        }
        System.out.println("]");
    }

    private void printRecommendResult() {
        for (Coach coach : CoachRepository.coaches()) {
            printRecommendedFoods(coach);
        }
    }

    private void printRecommendedFoods(Coach coach) {
        int index = 0;
        System.out.print("[ " + coach.getName() + " |");
        for (String foodName : coach.getRecommendedFoods()) {
            System.out.print(" " + foodName + " ");
            if (index < coach.getRecommendedFoods().size() - 1) {
                System.out.print("|");
            }
            index++;
        }
        System.out.println("]");
    }
}
