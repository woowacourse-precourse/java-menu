package menu;

import java.util.List;

public class Validation {
    public void validateCoachesName(List<String> coachesName) {
        for (int i = 0; i < coachesName.size(); i++) {
            if ((coachesName.get(i).length() < 2) || (coachesName.get(i).length() > 4)) {
                throw new IllegalArgumentException("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자입니다.");
            }
        }
    }

    public void validateHateFood(List<String> hateFood) {
        if (hateFood.size() < 0 || hateFood.size() > 2) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴는 최소 0개, 최대 2개입니다.");
        }
    }
}
