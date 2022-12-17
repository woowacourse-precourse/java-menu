package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomGenerator {

    public int pickRandomCategory(){
        return Randoms.pickNumberInRange(1, 5);
    }

    public String pickRandomMenu(List<String> menus){
        return Randoms.shuffle(menus).get(0);
    }
}
