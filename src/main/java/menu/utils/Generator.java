package menu.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class Generator {
    public String menuGenerator(Menu menu) {
        return Randoms.shuffle(menu.getMenu()).get(0);
    }


    public Menu categoryGenerator() {
        int index = Randoms.pickNumberInRange(1, 5);
        return Menu.values()[index];
    }
}
