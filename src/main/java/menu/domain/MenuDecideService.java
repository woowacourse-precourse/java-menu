package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.repository.MenuRepository;

public class MenuDecideService {
    public Coaches makeCoaches(String names) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : names.split(",")) {
            coaches.add(makeCoach(name));
        }
        return new Coaches(coaches);
    }

    private Coach makeCoach(String name) {
        return new Coach(name);
    }

    public void makeCantEatMenu(Coach coach, String menuNames) {
        List<Menu> menus = new ArrayList<>();
        for (String menuName : menuNames.split(",")) {
            menus.add(MenuRepository.findMenu(menuName));
        }
        coach.setMenus(new CantEatMenus(menus));
    }

    private Category decideCategory() {
        int number = Randoms.pickNumberInRange(1, 5);
        return Category.findByNumber(number);
    }
}
