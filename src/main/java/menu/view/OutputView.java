package menu.view;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.PickCategory;
import menu.utils.Category;
import menu.utils.Menu;

public class OutputView {

    private final String FIRST_RUN_MESSAGE = "점심 메뉴 추천을 시작합니다.\n";
    private final String GET_COACHES_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private final String RESULT_OF_MENU_RECOMMEND = "메뉴 추천 결과입니다.";
    private final String START_OF_MENU_DELIMITER = "[";
    private final String END_OF_MENU_DELIMITER = "]";
    private final String CENTER_OF_MENU_DELIMITER = "|";
    private final String PRINT_WEEKS = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private final String END_OF_MENU_RECOMMEND = "\n추천을 완료했습니다.";

    public void startMessage() {
        System.out.println(FIRST_RUN_MESSAGE);
    }

    public void getCoachesName() {
        System.out.println(GET_COACHES_NAME_MESSAGE);
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printMenu(Coaches coaches, PickCategory pickCategory) {
        System.out.println(RESULT_OF_MENU_RECOMMEND);
        System.out.println(PRINT_WEEKS);
        printCategory(pickCategory);
        printCoaches(coaches);
        System.out.println(END_OF_MENU_RECOMMEND);
    }

    public void printCategory(PickCategory pickCategory) {
        System.out.print(START_OF_MENU_DELIMITER);
        System.out.print(" 카테고리 ");
        for (Category category : pickCategory.getCategories()) {
            System.out.print(CENTER_OF_MENU_DELIMITER);
            System.out.print(" " + category.getCategory() + " ");
        }
        System.out.println(END_OF_MENU_DELIMITER);
    }

    public void printCoaches(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            printCoach(coach);
        }
    }

    public void printCoach(Coach coach) {
        System.out.print(START_OF_MENU_DELIMITER);
        System.out.print(" " + coach.getName() + " ");
        for (Menu menu : coach.getPickMenu()) {
            System.out.print(CENTER_OF_MENU_DELIMITER);
            System.out.print(" " + menu.getMenu() + " ");
        }
        System.out.println(END_OF_MENU_DELIMITER);
    }
}
