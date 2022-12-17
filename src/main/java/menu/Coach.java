package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> hateFood;
    private List<String> eatenFood = new ArrayList<>();

    public Coach(String name, List<String> hateFood) {
        this.name = name;
        this.hateFood = hateFood;
    }

    public String pickMenu(List<String> menus) {
        List<String> menusToShuffle = new ArrayList<>(menus);
        String pickedMenu = Randoms.shuffle(menusToShuffle).get(0);
        for (String hate : hateFood) {
            if (hate.equals(pickedMenu)) {
                return pickMenu(menus);
            }
        }
        for (String eaten : eatenFood) {
            if (eaten.equals(pickedMenu)) {
                return pickMenu(menus);
            }
        }
        eatenFood.add(pickedMenu);
        return pickedMenu;
    }

    public List<String> getEatenFood() {
        return eatenFood;
    }

    public String getName() {
        return name;
    }
}
