package menu.domain;

import java.util.List;

public class Validator {
    public Validator(){};

    public static void validateCoachName(List<String> coaches) {
        for (int i = 0; i < coaches.size(); i++)
            if (coaches.get(i).length() <2 || coaches.get(i).length() > 4)
                throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자 입니다.");
    }
}
