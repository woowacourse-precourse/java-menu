package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomPicker implements Picker {

    @Override
    public int pickNumberInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }

    @Override
    public List<String> shuffle(List<String> strings) {
        return Randoms.shuffle(strings);
    }
}
