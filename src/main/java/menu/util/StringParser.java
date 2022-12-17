package menu.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.model.Menu;
import menu.model.MenuRepository;

public class StringParser {
    public static List<String> parseByCommand(String input, String command) {
        return Arrays.stream(input.split(command)).map(String::trim).collect(Collectors.toList());
    }

    public static List<Menu> makeMenuListByCommand(String input, String command, MenuRepository menus) {
        if (input.trim().equals("")) {
            return Collections.emptyList();
        }
        return StringParser.makeListByCommand(input, command)
                .stream()
                .map(menus::getMenuByName)
                .collect(Collectors.toList());
    }
}
