package model;

import camp.nextstep.edu.missionutils.Randoms;

public class WeeklyMenuMakerGenerator {
    
    public int generate() {
        return Randoms.pickNumberInRange(1, 5);
    }
}
