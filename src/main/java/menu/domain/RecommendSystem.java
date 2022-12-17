package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RecommendSystem {

    private static final int RECOMMAND_MIN_NUM = 1;
    private static final int RECOMMAND_MAX_NUM = 5;

    private int randomCategory() {
        return Randoms.pickNumberInRange(RECOMMAND_MIN_NUM,RECOMMAND_MAX_NUM);
    }

}
