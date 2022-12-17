package menu.coach;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private List<String> hateFood  = new ArrayList<>();

    public Coach(String name) {
        validName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getHateFood() {
        return hateFood;
    }

    private void validName(String input) {
        if (input.length() > 4 || input.length() < 2) {
            throw new IllegalArgumentException("코치의 이름은 2~4 글자 입니다.");
        }
    }

    public void inputHateFoods(List<String> input) {
        if (input == null || input.size() > 2) {
            throw new IllegalArgumentException("싫어하는 음식은 0~2 개만 가능합니다.");
        }
        hateFood.addAll(input);
    }
}
