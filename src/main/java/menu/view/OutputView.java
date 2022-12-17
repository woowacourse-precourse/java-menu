package menu.view;

import java.util.List;
import menu.domain.Category;
import menu.domain.Days;

public class OutputView {

    private static final String SERVICE_START = "점심 메뉴 추천을 시작합니다.";
    private static final String GET_COACH_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String GET_CANT_EAT_MANUS = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String MENU_RESULT_INTRO = "메뉴 추천 결과입니다.";
    private static final String MENU_RESULT_ENDING = "추천을 완료했습니다.";
    private static final String SORTAION = "구분";
    private static final String CATEGORY = "카테고리";
    private static final String START_ARRAY = "[ ";
    private static final String END_ARRAY = " ]";
    private static final String SEPARATOR = " | ";

    public void printServiceStart() {
        System.out.println(SERVICE_START);
        System.out.println();
    }

    public void printGetCoachNames() {
        System.out.println(GET_COACH_NAMES);
    }

    public void printGetCantEatMenus(String name) {
        System.out.println(name + GET_CANT_EAT_MANUS);
    }

    public void printResult() {
        System.out.println(MENU_RESULT_INTRO);
        printDays();
        printCategory();
    }

    public void printEnding() {
        System.out.println();
        System.out.println(MENU_RESULT_ENDING);
    }

    public void printCoachMenus(String name, List<String> menus) {
        System.out.print(START_ARRAY);

        System.out.print(name);
        System.out.print(SEPARATOR);

        for (int i = 0; i < menus.size() - 1; i++) {
            System.out.print(menus.get(i));
            System.out.print(SEPARATOR);
        }
        System.out.print(menus.get(menus.size() - 1));

        System.out.println(END_ARRAY);
    }

    private void printDays() {
        System.out.print(START_ARRAY);

        System.out.print(SORTAION);
        System.out.print(SEPARATOR);
        for (int i = 0; i < Days.values().length - 1; i++) {
            System.out.print(Days.values()[i]);
            System.out.print(SEPARATOR);
        }
        System.out.print(Days.values()[Days.values().length - 1]);

        System.out.println(END_ARRAY);
    }

    private void printCategory() {
        System.out.print(START_ARRAY);

        System.out.print(CATEGORY);
        System.out.print(SEPARATOR);
        for (int i = 0; i < Category.values().length - 1; i++) {
            System.out.print(Category.values()[i]);
            System.out.print(SEPARATOR);
        }
        System.out.print(Category.values()[Category.values().length - 1]);

        System.out.println(END_ARRAY);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
