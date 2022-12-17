package menu.domain.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomCategoryStrategy implements CategoryStrategy {

    @Override
    public int generate(int inclusiveStart, int inclusiveEnd) {
        return Randoms.pickNumberInRange(inclusiveStart, inclusiveEnd);
    }
}
