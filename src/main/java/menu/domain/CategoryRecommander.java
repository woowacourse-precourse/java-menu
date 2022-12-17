package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CategoryRecommander {

    public Category randomRecommandCategory(){
        return  Category.of(Randoms.pickNumberInRange(1,5));
    }
}
