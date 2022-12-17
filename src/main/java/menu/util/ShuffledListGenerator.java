package menu.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class ShuffledListGenerator implements ListGenerator{
    @Override
    public List<String> getShuffledList(List<String> list) {
        return Randoms.shuffle(list);
    }
}
