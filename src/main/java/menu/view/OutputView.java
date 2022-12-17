package menu.view;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Day;
import menu.domain.Menu;

public class OutputView {


    private static final String START = "점심 메뉴 추천을 시작합니다.";
    private static final String ASK_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String ASK_CANT_EAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String PRINT_END_MESSAGE = "메뉴 추천 결과입니다.";

    public void printStartMessage() {
        System.out.println(START);
        printBlankLine();
    }

    private void printBlankLine() {
        System.out.println();
    }

    public void printAskNames() {
        System.out.println(ASK_NAMES);
    }

    public void printError(String message) {
        System.out.println(message);
    }

    public void printAskCoachCantEat(Coach coach) {
        System.out.printf(ASK_CANT_EAT, coach.getName());
    }

    public void printResult(Coaches coaches, List<Category> selectedCategories, List<List<Menu>> selectedMenus) {
        printEndMessage();
        printDays(coaches);
        printCategories(selectedCategories);
        for(int i=0;i<selectedMenus.size();i++){
            Coach coach = coaches.getCoach(i);
            printMenus(coach, selectedMenus.get(i));
        }
    }

    private void printMenus(Coach coach, List<Menu> menus) {
        System.out.print("[ "+ coach.getName()+ " ");
        for(Menu menu : menus){
            System.out.print("| " + menu.getMenu() + " ");
        }
        System.out.println("]");
    }

    private void printCategories(List<Category> selectedCategories) {
        System.out.print("[ 카테고리 ");
        for (Category category : selectedCategories) {
            System.out.print("| " + category.getCategory() + " ");
        }
        System.out.println("]");
    }

    private void printDays(Coaches coaches) {
        System.out.println(coaches.printAllDays());
    }

    private void printEndMessage() {
        System.out.println(PRINT_END_MESSAGE);
    }
}
