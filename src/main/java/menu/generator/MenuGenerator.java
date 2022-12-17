package menu.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MenuGenerator {
    public String pick(List<String> menus){
        return Randoms.shuffle(menus).get(0);
    }
}
