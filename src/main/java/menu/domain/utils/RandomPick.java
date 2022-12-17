package menu.domain.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomPick implements pick {

    @Override
    public int pickNumberInRange(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }

    @Override
    public List<String> shuffle(List<String> strings) {
        return Randoms.shuffle(strings);
    }
}