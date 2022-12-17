package menu.controller;

import menu.service.MenuService;
import menu.utils.MemberValid;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.Arrays;

public class Controller {
    private final MenuService menuService = new MenuService();

    public void run() {
        OutputView.printStart();
        saveMember();
        saveMenu();
        for (int i = 0; i < 5; i++) {
            recommendMenu();
        }
        OutputView.printResult(menuService.getWeekCategory(),menuService.getMembers());
    }

    private void recommendMenu() {
        menuService.recommendMenu();
    }

    private void saveMember() {
        String[] members = InputView.inputMember().split(",");
        try {
            MemberValid.isValidMember(members);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            saveMember();
            return;
        }
        try {
            saveNotEat(members);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            saveNotEat(members);
            return;
        }
    }

    private void saveNotEat(String[] members) {
        for (String member : members) {
            String[] notEats = InputView.inputNotEat(member).split(",");
            MemberValid.isValidNotEat(notEats);
            menuService.saveMember(member, Arrays.asList(notEats));
        }
    }

    private void saveMenu() {
        menuService.saveMenu();
    }
}
