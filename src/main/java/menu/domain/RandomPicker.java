package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomPicker implements Picker {

    @Override
    public int pickNumberInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
