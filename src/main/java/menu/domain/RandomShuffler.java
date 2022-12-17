package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomShuffler implements Shuffler {

    @Override
    public List<String> shuffle(List<String> list) {
        return Randoms.shuffle(list);
    }
}
