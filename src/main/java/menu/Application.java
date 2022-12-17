package menu;

import camp.nextstep.edu.missionutils.Console;
import menu.controller.MenuController;
import menu.model.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MenuController menuController = new MenuController();
        menuController.start();

    }
}
