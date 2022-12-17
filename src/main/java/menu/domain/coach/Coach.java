package menu.domain.coach;

import static menu.ConstantBox.RESULT_END;
import static menu.ConstantBox.RESULT_SEPARATOR;
import static menu.ConstantBox.RESULT_START;
import static menu.ConstantBox.ZERO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> selectedMenu = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void selectMenu(List<String> menus) {
        menus.removeIf(selectedMenu::contains);
        String menu = Randoms.shuffle(menus).get(0);
        selectedMenu.add(menu);
    }

    public String makeResultMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> tempCoachData = new ArrayList<>(selectedMenu);
        tempCoachData.add(ZERO, name);
        stringBuilder.append(RESULT_START).append(String.join(RESULT_SEPARATOR, tempCoachData)).append(RESULT_END);
        return stringBuilder.toString();
    }
}
