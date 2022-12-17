package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String[] readCoachNames() {
        String coachName = Console.readLine();
        return coachName.split(",");
    }

    public String[] readNoEatMenu() {
        String coachName = Console.readLine();
        String[] split = coachName.split(",");
        if (split.length <= 0 || 3 <= split.length) {
            throw new IllegalArgumentException("길이가 잘못 되었습니다.");
        }
        return split;
    }
}
