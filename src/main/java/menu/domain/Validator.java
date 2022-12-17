package menu.domain;

import java.util.List;

public class Validator {
    public Validator(){};

    public static void validateCoachName(List<String> coaches) {
        for (int i = 0; i < coaches.size(); i++)
            if (coaches.get(i).length() <2 || coaches.get(i).length() > 4)
                throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자 입니다.");
    }

    public static void validateCoachesLength(List<String> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5)
            throw new IllegalArgumentException("코치는 최소 2명 이상, 5명 이하로 입력해야 합니다.");
    }

    public static void validateInEdibleMenuLength(List<String> inEdibleMenu) {
        if (inEdibleMenu.size() > 2)
            throw new IllegalArgumentException("먹지 못하는 메뉴는 최대 2개까지 입력이 가능합니다.");
    }
}
