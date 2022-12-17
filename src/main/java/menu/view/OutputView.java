package menu.view;

import menu.enums.MenuOption;
import menu.model.Coach;
import menu.model.CoachRepository;

import java.util.List;

import static menu.message.OutputMsg.*;

public class OutputView {

    private static final int ONE = 1;

    public void printStart() {
        System.out.println(OUTPUT_MSG_SERVICE_START.get());
    }

    public void printEnd() {
        System.out.print(OUTPUT_MSG_SERVICE_END_PREFIX.get());
        printCategory();
        printMenu();
        System.out.println(OUTPUT_MSG_SERVICE_END_POSTFIX.get());
    }

    private void printCategory() {
        List<MenuOption> categories = CoachRepository.categories();
        int lastIndex = categories.size() - ONE;

        for (int index = 0; index < categories.size(); index++) {
            System.out.print(categories.get(index).getCategory());
            if (index != lastIndex) {
                System.out.print(MIDDLE_BRAKET.get());
            }
        }

        System.out.println(CLOSE_BRAKET.get());
    }

    private void printMenu() {
        //TODO: 너무 길어 메서드 분리
        List<Coach> coaches = CoachRepository.coaches();

        for (Coach coach : coaches) {
            int lastIndex = coach.getChoicedMenus().size() - ONE;
            System.out.print(OPEN_BRAKET.get() + coach.getName() + MIDDLE_BRAKET.get());
            for (String menu : coach.getChoicedMenus()) {
                System.out.print(menu);
                if (coach.getChoicedMenus().indexOf(menu) != lastIndex) {
                    System.out.print(MIDDLE_BRAKET.get());
                }
            }
            System.out.println(CLOSE_BRAKET.get());
        }
    }

    public void printMessage(String message) {
        System.out.print("\n" + message);
    }
}
