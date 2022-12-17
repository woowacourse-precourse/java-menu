package model;

import camp.nextstep.edu.missionutils.Randoms;

public class WeeklyRandomMenuMakerGenerator implements WeeklyMenuMakerGenerator {
    
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 5;
    
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
