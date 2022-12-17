package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumGenerator {
    public static int makeCategoryNum (){
        int num = Randoms.pickUniqueNumbersInRange(1,5);
        return num;
    }
}

