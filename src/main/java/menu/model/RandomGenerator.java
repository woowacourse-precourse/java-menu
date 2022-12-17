package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    public int pickRandomCategory(){
        return Randoms.pickNumberInRange(1, 5);
    }
}
