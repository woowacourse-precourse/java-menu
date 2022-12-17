package menu;

import camp.nextstep.edu.missionutils.Randoms;
public class CategoryGenerator {

    // 한식인지 일식인지 리턴
    public static String randomCategory(CategoryLists categories){
        String category = categories.get(randomNumber());
        return category;
    }

    // 랜덤 숫자 생성
    public static int randomNumber(){
        return Randoms.pickNumberInRange(1, 5);
    }
}
