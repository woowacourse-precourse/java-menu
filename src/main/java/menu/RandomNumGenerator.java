package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumGenerator {
    public static int makeCategoryNum (){
        int num = Randoms.pickNumberInRange(1,5);
        return num;
    }
}

