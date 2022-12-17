package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {
    private static final String WHITE_SPACE = " ";
    public static final int NAME_LENGTH_LOWER_BOUNDS = 2;
    public static final int NAME_LENGTH_UPPER_BOUNDS = 4;
    public static final int NO_EAT_NUMBER_UPPER_BOUNDS = 2;
    private final String name;
    private final Menus noEat;
    private final Menus eaten;

    public Coach(String name, Menus noEat) {
        validate(name);
        this.name = name;
        this.noEat = noEat;
        this.eaten = new Menus();
    }

    private void validate(String name) {
        if (name.contains(WHITE_SPACE)) {
            throw new IllegalArgumentException("이름 형식 에러");
        }
        if (name.length() < NAME_LENGTH_LOWER_BOUNDS || name.length() > NAME_LENGTH_UPPER_BOUNDS) {
            throw new IllegalArgumentException("이름 길이 에러");
        }
    }

    public void receiveRecommendation(Menus allMenus, Category category, RecommendationMachine recommendationMachine) {
        Menus notAllowed = noEat.combine(eaten);
        eaten.add(recommendationMachine.menu(allMenus, category, notAllowed));
    }

    public List<String> getRecommendationResult() {
        List<String> result = new ArrayList<>(eaten.getNames());
        result.add(0, name);
        return Collections.unmodifiableList(result);
    }
}
