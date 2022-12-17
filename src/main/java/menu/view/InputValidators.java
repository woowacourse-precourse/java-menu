package menu.view;

import menu.entity.Coach;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputValidators {

    static void validateCoachesSize(List<Coach> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException("코치는 2명에서 5명이여야 합니다.");
        }
    }

    static void validateHateMenusSize(List<String> hateMenus) {
        if (hateMenus.size() > 2) {
            throw new IllegalArgumentException("못먹는 메뉴는 0개에서 2개여야합니다.");
        }
    }

    static void validateDuplicateCoachName(List<Coach> coaches) {
        Set<String> names = coaches.stream()
                .map(Coach::getName)
                .collect(Collectors.toSet());

        if (coaches.size() != names.size())
            throw new IllegalArgumentException("코치의 이름은 중복되어선 안됨");
    }

    static void validateDuplicateHateMenuName(List<String> hateMenus) {
        Set<String> hateMenuSet = new HashSet<>(hateMenus);
        if (hateMenus.size() != hateMenuSet.size())
            throw new IllegalArgumentException("못먹는 메뉴의 이름은 중복되어선 안됨");
    }
}
