package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.dto.CompleteMenuDto;
import menu.type.CategoryList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CoachRepository {

    private static final List<Coach> coachs = new ArrayList<>();

    public static void add(Coach coach) {
        coachs.add(coach);
    }

    public static List<String> getAllNames() {
        return coachs.stream().map(Coach::getName).collect(Collectors.toList());
    }

    public static Coach findByName(String coachName) {
        return coachs.stream()
                .filter(coach -> coach.getName().equals(coachName))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public static void pickMenus(List<String> categoryList) {
        for (String category : categoryList) {
            pickMenuForEachCategory(category);
        }
    }

    private static void pickMenuForEachCategory(String category) {
        for (Coach coach : coachs) {
            pickMenu(CategoryList.getMenusByCategory(category), coach);

        }
    }

    private static void pickMenu(List<String> menus, Coach coach) {
        while (true) {
            ArrayList<String> copyMenus = new ArrayList<>(menus);
            String menu = Randoms.shuffle(copyMenus).get(0);
            if (coach.isOkayToCompleteMenu(menu)) {
                coach.addCompleteMenu(menu);
                break;
            }
        }
    }

    public static List<CompleteMenuDto> getCompleteMenuDtos() {
        List<CompleteMenuDto> dtos = new ArrayList<>();
        for (Coach coach : coachs) {
            dtos.add(new CompleteMenuDto(coach.getName(), coach.getCompleteMenus()));
        }
        return dtos;
    }
}
