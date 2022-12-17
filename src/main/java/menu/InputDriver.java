package menu;

import camp.nextstep.edu.missionutils.Console;

public class InputDriver {
    // 구분자가 앞 뒤로 있는 경우 에러
    // 코치의 이름이 2-4 가 안되는 경우
    // 코치의 명 수가 2-5 명인 경우
    public String scanCoachName() {
        return Console.readLine();
    }

    
    // 구분자가 앞뒤로 있는 경우 에러
    // 0-2 개 초과인 경우 에러
    public String scanCannotEatMenu() {
        return Console.readLine();
    }
}
