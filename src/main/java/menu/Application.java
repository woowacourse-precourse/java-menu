package menu;

import menu.domain.Coach;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static List<Coach> createCoachList(List<String> coaches, List<List<String>> unavailableMenus) {
        List<Coach> result = new ArrayList<>();

        for (int coachIndex = 0; coachIndex < coaches.size(); coachIndex++) {
            String name = coaches.get(coachIndex);
            List<String> banedMenu = unavailableMenus.get(coachIndex);

            result.add(new Coach(name, banedMenu));
        }

        return result;
    }
}
