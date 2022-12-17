package model;

import camp.nextstep.edu.missionutils.Randoms;

public class WeeklyRandomMenuMakerGenerator implements WeeklyMenuMakerGenerator {
    
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(1, 5);
    }
}
