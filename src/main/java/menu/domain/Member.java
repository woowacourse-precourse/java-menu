package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Member {
    private static final int COUNT_UPPER = 5;
    private static final int COUNT_LOWER = 2;

    private final List<Coach> coaches = new ArrayList<>();


    public Member(List<String> coachNames) {
        validateCountOfCoach(coachNames);
        for (String coachName : coachNames) {
            Coach coach = new Coach(coachName);
            coaches.add(coach);
        }
    }

    private void validateCountOfCoach(List<String> coachNames) {
        if (coachNames.size() < COUNT_LOWER || coachNames.size() > COUNT_UPPER) {
            throw new IllegalArgumentException("[ERROR] 멤버 수는 2명부터 5명 까지 입니다.");
        }
    }

    public List<String> getNames() {
        List<String> coachNames = new ArrayList<>();
        for (Coach coach : coaches) {
            coachNames.add(coach.getName());
        }
        return Collections.unmodifiableList(coachNames);
    }

    public void addNotEatingMenus(String coachName, List<String> menus) {
        Coach coach = findCoach(coachName);
        for (String menu : menus) {
            coach.addNotEatingMenu(menu);
        }
    }


    public void addRecommandMenuToCoach(Category category, Coach coach) {
        try {
            String menu = Randoms.shuffle(category.getMenus()).get(0);
            coach.addRecommandMenu(menu);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            if (!coach.flag) {
                addRecommandMenuToCoach(category, coach);
            }
        }
    }

    public Coach findCoach(String coachName) {
        for (Coach coach : coaches) {
            if (coach.isSameName(coachName)) {
                return coach;
            }
        }
        throw new IllegalArgumentException("[ERROR] 해당이름의 코치가 존재하지않습니다.");
    }

    public List<String> getCategoryNames() {
        return coaches.get(0).getCategoryNames();
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }
}
