package constant;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Menu {
    FIRST("1", "1. 첫번째 메뉴"),
    QUIT("Q", "Q. 종료");

    private final String menuCommand;
    private final String menuName;

    Menu(String menuCommand, String menuName) {
        this.menuCommand = menuCommand;
        this.menuName = menuName;
    }

    public static Menu getMenuByName(String input) {
        return Arrays.stream(Menu.values())
                .filter(command -> command.menuCommand.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("정확한 메뉴 번호를 입력하세요."));
    }

    public static String getWholeMenu() {
        return Arrays.stream(Menu.values())
                .map(menu -> menu.menuName)
                .collect(Collectors.joining("\n"));
    }

    public String getGameCommand() {
        return this.menuCommand;
    }
}
