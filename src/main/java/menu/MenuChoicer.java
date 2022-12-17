package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.type.CategoryType;

public class MenuChoicer {
    private final Map<String, List<String>> chosenMenuMap = new HashMap<>();
    private final CoachHates coachHates;

    public MenuChoicer(List<String> coaches, CoachHates coachHates) {
        for (int i = 0; i < coaches.size(); i++) {
            this.chosenMenuMap.put(coaches.get(i), new ArrayList<>());
        }
        this.coachHates = coachHates;
    }

    public Map<String, List<String>> getChosenMenuMap() {
        return this.chosenMenuMap;
    }

    public CategoryType chooseRandomCategory() {
        int number = Randoms.pickNumberInRange(1, 5);
        for (CategoryType categoryType : CategoryType.values()) {
            if (categoryType.getNumber() == number) {
                return categoryType;
            }
        }
        return null;
    }

    public String chooseRandomMenu(List<String> menus) {
        String menu = Randoms.shuffle(menus).get(0);
        return menu;
    }

    public void updateChosenMenu(String coachName, String menu) {
        this.chosenMenuMap.get(coachName).add(menu);
    }
}
