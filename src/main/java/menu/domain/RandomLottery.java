package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottery {

    public int setRandomNumber() {

        return Randoms.pickNumberInRange(0, 4);
    }

    public String setShuffleMenu(List<String> menu) {
        return Randoms.shuffle(menu).get(0);
    }

}
